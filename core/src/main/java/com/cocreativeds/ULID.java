package com.cocreativeds;
/**
 * Universally Unique Lexicographically Sortable Identifier(ULID)
 * 
 * <p>
 * 26バイト文字列のULIDを生成します。 
 * ULIDの詳細は、@see <a href="https://github.com/ulid/spec">ulid/spec</a>を参照願います。 
 * 
 */

import java.security.SecureRandom;

public class ULID {

    /**
     *  Unixエポック時刻(ミリ秒)の最小値 
     */
    private static final long MIN_TIME = 0x0L;
    /**
     * Unixエポック時刻(ミリ秒)の最大値
     * 
     * <p>
     * ULIDでは時刻の48ビットを使用します。
     */
    private static final long MAX_TIME = 0x0000ffffffffffffL;

    /**
     * Crockford Base32エンコードのためのマスク
     * 
     * <p>
     * Base32では5ビットごとにエンコードします。この定数はエンコード対象以外のビットをマスク(ゼロに)するために使用します。
     * エンコード対象の5ビットを右端にシフトして0x1fと論理積(and)することでエンコード対象の5ビットだけを取り出すことができます。
     */
    private static final byte ENCODE_MASK = 0x1f;

    /**
     * Crockford Base32エンコード文字列
     * 
     * <p>
     * @see <a href="https://www.crockford.com/base32.html">Crockford Base32</a>は、
     * 0〜9の数字10文字とI, L, O, U以外の英字大文字(22文字)を使用してエンコードします。
     */
    private static final char[] ENCODE_CHAR = new char[] {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',   // 0〜9
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K',   // 10〜19
        'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X',   // 20〜29 
        'Y', 'Z'                                            // 30〜31
    };

    /**
     * ULID文字列の生成
     * 
     * <p>
     * タイムスタンプと乱数からULIDを26バイトの文字列として生成します。
     * 
     * @return ULID
     */
    public static String generate() {
        return genULIDString(System.currentTimeMillis(), randomValue());
    }
    
    /**
     * ULID文字列の生成
     * 
     * <p>
     * タイムスタンプと乱数それぞれについてCrockford Base32エンコードを行って文字列のULIDを生成します。生成されるULIDは以下の形式です。
     * 
     * <p>
     * ttttttttttrrrrrrrrrrrrrrrr
     * 
     * <p>
     * t: タイムスタンプ(10バイト)
     * <p>
     * r: 乱数(16バイト)
     * 
     * @param currentTime ミリ秒単位のUnixエポック時刻
     * @param randomBytes 乱数を含むバイト配列(10バイト)
     * @return 文字列型のULID
     * @throws IllegalArgumentException タイムスタンプが最小値未満または最大値より大きいとき
     * @throws IllegalArgumentException 乱数を含むバイト配列の長さが正しくないとき
     */
    public static String genULIDString(long currentTime, byte[] randomBytes) {

        //タイムスタンプの正当性チェック
        if (MIN_TIME <= currentTime && currentTime <= MAX_TIME) {
            // タイムスタンプは正常
        } else {
            throw new IllegalArgumentException("タイムスタンプが最小値未満または最大値を超えています");
        }

        //乱数が含まれるバイト型配列の長さチェック
        if (randomBytes.length == 10) {
            // 配列の長さは正当
        } else {
            throw new IllegalArgumentException("乱数が含まれるバイト型配列の長さは10でなければなりません");
        }

        /* ULID文字列を生成するためのchar型配列
            5ビットごとにエンコードしてchar型配列に保管した後に26バイトの文字列に変換してリターンします。
        */
        char[] chars = new char[26];

        /* タイムスタンプのエンコード
            タイムスタンプは48ビットで構成されています。エンコード対象の5ビットが右端に来るようにシフトしエンコードします。
            最初のエンコード対象を取り出すためにシフトするビット数を45としてエンコードします。
        */
        
        int shiftBit = 45;

        for (int i = 0; i < 10; i++) {
            /*  エンコード対象のビットを右端にシフトして、上位の3ビットをマスク(オフ)することで5ビットの整数値(0〜31)に変換しています。
                この整数値をエンコード文字を含む配列の添字として該当の文字にエンコードしています。
            */
            chars[i] = ENCODE_CHAR[(byte)(currentTime >>> shiftBit) & ENCODE_MASK];
            //シフトするビット数を5ビットずらします
            shiftBit = shiftBit - 5;
        }

        /* 乱数のエンコード
            乱数を含むバイト配列の先頭から5ビットごとに取り出して5ビットの整数値(0〜31)を得てエンコードします。

            byte型の最上位ビット(MSB)が1のとき、右にシフトしてもMSBはゼロになりません。byte型の演算はint型に変換した後で行われ
            ます。byte型の変数の先頭ビットがオンのときは負の値としてint型に変換されてしまいます。そのためbyte型の右シフトを行った
            ときに左側のビットがゼロにならず1になってしまいます。この状況を回避するため、0xffでマスクした後で右にシフトします。
            int型に変換後0xffでマスクすることで上位の24ビットがオフされ、右にシフトすることで左側のビットがゼロになります。
        */

        //バイト配列0のビット0〜4を3ビット右にシフトすることで5ビットの整数値に変換してエンコード
        chars[10] = ENCODE_CHAR[(byte)((randomBytes[0] & 0xff) >>> 3)];

        /*  バイト配列0のビット5〜7を左に2ビットシフトしてビット3〜5とし、バイト配列1のビット0〜1と論理和をとり、
            0x1fでマスクすることで5ビットの整数値に変換してエンコード
        */
        chars[11] = ENCODE_CHAR[(byte)((randomBytes[0] << 2) | ((randomBytes[1] & 0xff) >>> 6)) & ENCODE_MASK];

        /*  バイト配列1のビット2〜6を右に1ビットシフトしてビット3〜7とし、0x1fでマスクすることで5ビットの
            整数値に変換してエンコード
        */
        chars[12] = ENCODE_CHAR[(byte)((randomBytes[1] &0xff) >>> 1) & ENCODE_MASK];

        /*  バイト配列1のビット7を左に4ビットシフトしてビット3とし、バイト配列2のビット0〜4と論理和をとり、
            0x1fでマスクすることで5ビットの整数値に変換してエンコード
        */
        chars[13] = ENCODE_CHAR[(byte)((randomBytes[1] << 4) | ((randomBytes[2] & 0xff) >>> 4)) & ENCODE_MASK];

        /*  バイト配列2のビット5〜7を左に1ビットシフトしてビット3〜6とし、バイト配列3のビット0と論理和をとり、
            0x1fでマスクすることで5ビットの整数値に変換してエンコード
        */
        chars[14] = ENCODE_CHAR[(byte)((randomBytes[2] << 1) | ((randomBytes[3] & 0xff) >>> 7)) & ENCODE_MASK];

        /*  バイト配列3のビット1〜5を右に2ビットシフトしてビット3〜7とし、0x1fでマスクすることで5ビットの
            整数値に変換してエンコード
        */
        chars[15] = ENCODE_CHAR[(byte)((randomBytes[3] & 0xff) >>> 2) & ENCODE_MASK];

        /*  バイト配列3のビット6〜7を左に4ビットシフトしてビット3〜4とし、バイト配列4のビット0〜2と論理和をとり、
            0x1fでマスクすることで5ビットの整数値に変換してエンコード
        */
        chars[16] = ENCODE_CHAR[(byte)((randomBytes[3] << 3) | ((randomBytes[4] & 0xff) >>> 5)) & ENCODE_MASK];

        //  バイト配列4のビット3〜7を0x1fでマスクすることで5ビットの整数値に変換してエンコード
        chars[17] = ENCODE_CHAR[(byte)randomBytes[4] & ENCODE_MASK];

        //  バイト配列5のビット0〜4を3ビット右にシフトすることで5ビットの整数値に変換してエンコード
        chars[18] = ENCODE_CHAR[(byte)((randomBytes[5] & 0xff) >>> 3)];

        /*  バイト配列5のビット5〜7を左に2ビットシフトしてビット3〜5とし、バイト配列6のビット0〜1と論理和をとり、
            0x1fでマスクすることで5ビットの整数値に変換してエンコード
        */
        chars[19] = ENCODE_CHAR[(byte)((randomBytes[5] << 2) | ((randomBytes[6] & 0xff) >>> 6)) & ENCODE_MASK];

        /*  バイト配列6のビット2〜6を右に1ビットシフトしてビット3〜7とし、0x1fでマスクすることで5ビットの
            整数値に変換してエンコード
        */
        chars[20] = ENCODE_CHAR[(byte)((randomBytes[6] & 0xff) >>> 1) & ENCODE_MASK];

        /*  バイト配列6のビット7を左に4ビットシフトしてビット3とし、バイト配列7のビット0〜4と論理和をとり、
            0x1fでマスクすることで5ビットの整数値に変換してエンコード
        */
        chars[21] = ENCODE_CHAR[(byte)((randomBytes[6] << 4) | ((randomBytes[7] & 0xff) >>> 4)) & ENCODE_MASK];

        /*  バイト配列7のビット5〜7を左に1ビットシフトしてビット3〜6とし、バイト配列8のビット0と論理和をとり、
            0x1fでマスクすることで5ビットの整数値に変換してエンコード
        */
        chars[22] = ENCODE_CHAR[(byte)((randomBytes[7] << 1) | ((randomBytes[8] & 0xff) >>> 7)) & ENCODE_MASK];

        /*  バイト配列8のビット1〜5を右に2ビットシフトしてビット3〜7とし、0x1fでマスクすることで5ビットの
            整数値に変換してエンコード
        */
        chars[23] = ENCODE_CHAR[(byte)((randomBytes[8] & 0xff) >>> 2) & ENCODE_MASK];

        /*  バイト配列8のビット6〜7を左に4ビットシフトしてビット3〜4とし、バイト配列9のビット0〜2と論理和をとり、
            0x1fでマスクすることで5ビットの整数値に変換してエンコード
        */
        chars[24] = ENCODE_CHAR[(byte)((randomBytes[8] << 3) | ((randomBytes[9] & 0xff) >>> 5)) & ENCODE_MASK];

        //バイト配列9のビット3〜7を0x1fでマスクすることで5ビットの整数値に変換してエンコード
        chars[25] = ENCODE_CHAR[(byte)randomBytes[9] & ENCODE_MASK];

        return new String(chars);
    }
    
    /**
     * ULIDの下位10バイト(80ビット)に設定する乱数列を生成する
     * 
     * <p>
     * バイト型の配列10個に乱数を生成して応答します。<a href="https://docs.oracle.com/javase/jp/21/docs/api/java.base/java/util/Random.html#nextBytes(byte[])">nextByte</a>
     * メソッドはバイト型配列の長さ分の乱数を生成して配列に配置します。
     * 
     * @return 乱数が含まれるバイト型配列10個
     */
    private static byte[] randomValue() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[10];
        random.nextBytes(bytes);
        return bytes;
    }

}
