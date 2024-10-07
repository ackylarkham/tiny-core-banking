package com.cocreativeds;
import java.util.Objects;
/**
 * 口座番号クラス。
 * Account number class.
 * 
 * <p>日本の銀行における口座番号7桁を表すクラス<BR>
 * Account number(7 digit) class for Japanese bank.
 * 
 */
public class AccountNumber {

    /* 口座番号 */
    private String accountNumber;

    /**
     * コンストラクター。
     * 
     * <p>指定された口座番号でインスタンスを生成する。
     * 
     * @param an 口座番号
     */
    public AccountNumber(String an) {
        this.setAccountNumber(an);
    }

    /**
     * デフォルトコンストラクター<BR>
     * 
     * <p>口座番号として"0000000"を設定する。
     */
    public AccountNumber() {
        this("0000000");
    }

    /**
     * 口座番号を取得する。
     * 
     * <p>インスタンスが持つ口座番号を取得する。
     * 
     * @return 口座番号 account number
     */
    public String getAccountNumber() {
        return this.accountNumber;
    }
    /**
     * 口座番号を設定する。
     * 
     * <p>インスタンスに口座番号を設定する。
     * 
     * @param an 口座番号
     * @throws IllegalArgumentException 口座番号が7桁の数字でないとき
     */
    public void setAccountNumber(String an) {
        if (an == null) {
            throw new IllegalArgumentException("口座番号は7桁の数字でなくてはならない");
        } else {
            if (an.matches("[0-9]{7}")) {  // 7桁の数字？
                this.accountNumber = an;
            } else {
                throw new IllegalArgumentException("口座番号は7桁の数字でなくてはならない");
            }
        }
    }

    /**
     * 文字列表現
     * 
     * <P>インスタンスの文字列表現メソッドです。インスタンスが保持している口座番号を返します。
     * 
     * @return 口座番号
     */
    public String toString() {
        return "口座番号: " + this.accountNumber;
    }

    /**
     * 等価判定
     * 
     * <P>インスタンスの等価判定メソッドです。インスタンスが等価であるか否かをbooleanで返します。
     * 
     * @return true 等価である
     * @return false 等価でない
     */
    public boolean equals(Object o) {
        if (o instanceof AccountNumber) { //比較対象はAccountNumberクラスのインスタンス?
            if (o == this) {
                return true;
            } else {
                AccountNumber b = (AccountNumber)o;
                if (this.accountNumber.equals(b.accountNumber)) { //口座番号が一致する?
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    /**
     * ハッシュ値を得る
     * 
     * <p>インスタンスのハッシュ値を返します。
     * 
     * @return ハッシュ値
     */
    public int hashCode() {
        return Objects.hash(this.accountNumber);
    }

    /**
     * 大小関係を判定する
     * 
     * <p>インスタンスの大小関係を判定し結果を返します。
     * 
     * @return 負 比較対象が大きい
     * @return 0 比較対象と等しい
     * @return 正 比較対象が小さい
     */
    public int compareTo(AccountNumber o) {
        return this.accountNumber.compareTo(o.accountNumber);
    }

    /**
     * 口座番号のコピー
     * 
     * <p>インスタンスをコピーします。
     * 
     * @return コピーされた口座番号
     */
    public AccountNumber clone() {
        return new AccountNumber(this.accountNumber);
    }
}
