package com.cocreativeds;
import java.util.Objects;
/**
 * 金融機関コードクラス
 * <p>
 * 金融機関コードは、日本国内の金融機関を識別する4桁の数字である。
 */
public class BankCode implements Comparable<BankCode>, Cloneable {

    /* 金融機関コード */
    private String bankCode;

    /**
     * 金融機関コードを設定してインスタンスを生成する
     * @param bc 金融機関コード
     */
    public BankCode(String bc) {
        this.setBankCode(bc);
    }

    /**
     * デフォルトコンストラクター
     * <p>
     * 金融機関コードとして"0000"を設定する。(金融機関コード"0000"を持つ金融機関は実在しない)
     * 常に"0000"を設定するためBankCode(bc)コンストラクターの呼び出しは行わない。
     */
    public BankCode() {
        this.bankCode = "0000";
    }

    /**
     * 金融機関コードを取得する
     * @return 金融機関コード
     */
    public String getBankCode() {
        return this.bankCode;
    }
    /**
     * 金融機関コードを設定する
     * @param bc 金融機関コード
     * @throws IllegalArgumentException 金融機関コードは４桁の数字でなくてはならない
     */
    public void setBankCode(String bc) {
        if (bc == null) {
            throw new IllegalArgumentException("金融機関コードは4桁の数字でなくてはならない");
        } else {
            if (bc.matches("[0-9]{4}")) {  // 4桁の数字？
                this.bankCode = bc;
            } else {
                throw new IllegalArgumentException("金融機関コードは4桁の数字でなくてはならない");
            }
        }
    }

    /**
     * 文字列表現
     * @return 金融機関コード
     */
    public String toString() {
        return "金融機関コード: " + this.bankCode;
    }

    /**
     * 等価判定
     * @return true 等価である
     * @return false 等価でない
     */
    public boolean equals(Object o) {
        if (o instanceof BankCode) { //比較対象はBankCodeクラスのインスタンス?
            if (o == this) {
                return true;
            } else {
                BankCode b = (BankCode)o;
                if (this.bankCode.equals(b.bankCode)) { //金融機関コードが一致する?
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
     * @return ハッシュ値
     */
    public int hashCode() {
        return Objects.hash(this.bankCode);
    }

    /**
     * 大小関係を判定する
     * @return -1 比較対象が大きい
     * @return 0 比較対象と等しい
     * @return 1 比較対象が小さい
     */
    public int compareTo(BankCode o) {
        return this.bankCode.compareTo(o.bankCode);
    }

    /**
     * 金融機関コードのコピー
     * @return コピーされた金融機関コード
     */
    public BankCode clone() {
        return new BankCode(this.bankCode);
    }
}
