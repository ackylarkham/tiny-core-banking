package com.cocreativeds;

import java.util.Objects;
/**
 * 預金種目コードクラス
 * <p>
 * 全銀で規定されている預金種目コード
 */
public class AccountTypeCode implements Comparable<AccountTypeCode>, Cloneable {

    /* 預金種目コード */
    private String accountTypeCode;

    /**
     * 預金種目コードを設定してインスタンスを生成する
     * @param ac 預金種目コード
     */
    public AccountTypeCode(String ac) {
        this.setAccountTypeCode(ac);
    }

    /**
     * デフォルトコンストラクター
     * <p>
     * 預金種目コードとして"0"を設定する。
     * 常に"0"を設定するためAccountTypeCode(ac)コンストラクターの呼び出しは行わない。
     */
    public AccountTypeCode() {
        this.accountTypeCode = "0";
    }

    /**
     * 預金種目を取得する
     * @return 預金種目コード
     */
    public String getAccountTypeCode() {
        return this.accountTypeCode;
    }
    /**
     * 預金種目コードを設定する
     * @param ac 預金種目コード
     * @throws IllegalArgumentException 預金種目コードは1桁の数字でなくてはならない
     */
    public void setAccountTypeCode(String bo) {
        if (bo == null) {
            throw new IllegalArgumentException("預金種目コードは1桁の数字でなくてはならない");
        } else {
            if (bo.matches("[0-9]{1}")) {  // 3桁の数字？
                this.accountTypeCode = bo;
            } else {
                throw new IllegalArgumentException("預金種目コードは1桁の数字でなくてはならない");
            }
        }
    }

    /**
     * 文字列表現
     * @return 預金種目コード
     */
    public String toString() {
        return "預金種目コード: " + this.accountTypeCode;
    }

    /**
     * 等価判定
     * @return true 等価である
     * @return false 等価でない
     */
    public boolean equals(Object o) {
        if (o instanceof AccountTypeCode) { //比較対象はAccountTypeCodeクラスのインスタンス?
            if (o == this) {
                return true;
            } else {
                AccountTypeCode b = (AccountTypeCode)o;
                if (this.accountTypeCode.equals(b.accountTypeCode)) { //預金種目コードが一致する?
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
        return Objects.hash(this.accountTypeCode);
    }

    /**
     * 大小関係を判定する
     * @return -1 比較対象が大きい
     * @return 0 比較対象と等しい
     * @return 1 比較対象が小さい
     */
    public int compareTo(AccountTypeCode o) {
        System.out.println("this: " + this.accountTypeCode);
        System.out.println("o: " + o.accountTypeCode);
        System.out.println("result: " + this.accountTypeCode.compareTo(o.accountTypeCode));
        return this.accountTypeCode.compareTo(o.accountTypeCode);
    }

    /**
     * 預金種目コードのコピー
     * @return コピーされた預金種目コード
     */
    public AccountTypeCode clone() {
        return new AccountTypeCode(this.accountTypeCode);
    }
}
