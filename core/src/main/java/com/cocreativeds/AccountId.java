package com.cocreativeds;

import java.util.Objects;
/**
 * 口座識別子クラス。
 * Account ID class.
 * 
 * <P>口座をユニークに識別するための識別子を表すクラスです。口座識別子は、口座開設時に採番されます。
 * 取引店変更や店舗統廃合によって変更されることはありません。また、永続化のためのキーとして使用されます。
 * 
 * <P>AccountId class is an identifier to uniquely identify an account. It is numbered at 
 * the time the account is opened. AccountId will not be changed due to a change of branch 
 * office or branch consolidation. It is also used as a key for persistence.
 * 
 */

public class AccountId {
    /* 口座識別子 */
    private String accountId;

    /**
     * コンストラクター。
     * 
     * <p>指定された口座識別子でインスタンスを生成する。
     * 
     * @param aid 口座識別子
     */
    public AccountId(String aid) {
        this.setAccountId(aid);
    }

    /**
     * デフォルトコンストラクター<BR>
     * 
     * <p>口座識別子として"0000000"を設定する。
     */
    public AccountId() {
        this("0000000");
    }

    /**
     * 口座識別子を取得する。
     * 
     * <p>インスタンスが持つ口座識別子を取得する。
     * 
     * @return 口座識別子 account number
     */
    public String getAccountId() {
        return this.accountId;
    }
    /**
     * 口座識別子を設定する。
     * 
     * <p>インスタンスに口座識別子を設定する。
     * 
     * @param aid 口座識別子
     * @throws IllegalArgumentException 口座識別子が7桁の数字でないとき
     */
    public void setAccountId(String aid) {
        if (aid == null) {
            throw new IllegalArgumentException("口座識別子は7桁の数字でなくてはならない");
        } else {
            if (aid.matches("[0-9]{7}")) {  // 7桁の数字？
                this.accountId = aid;
            } else {
                throw new IllegalArgumentException("口座識別子は7桁の数字でなくてはならない");
            }
        }
    }

    /**
     * 口座識別子を生成する
     * 
     * <p>ユニークな口座識別子を生成する
     * 
     * @return 口座識別子
     */
    public String generateAccountId() {
        return "";
    }
    /**
     * 文字列表現
     * 
     * <P>インスタンスの文字列表現メソッドです。インスタンスが保持している口座識別子を返します。
     * 
     * @return 口座識別子
     */
    public String toString() {
        return "口座識別子: " + this.accountId;
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
        if (o instanceof AccountId) { //比較対象はAccountIdクラスのインスタンス?
            if (o == this) {
                return true;
            } else {
                AccountId b = (AccountId)o;
                if (this.accountId.equals(b.accountId)) { //口座識別子が一致する?
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
        return Objects.hash(this.accountId);
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
    public int compareTo(AccountId o) {
        return this.accountId.compareTo(o.accountId);
    }

    /**
     * 口座識別子のコピー
     * 
     * <p>インスタンスをコピーします。
     * 
     * @return コピーされた口座識別子
     */
    public AccountId clone() {
        return new AccountId(this.accountId);
    }
}