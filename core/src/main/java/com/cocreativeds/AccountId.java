package com.cocreativeds;

import java.util.Objects;
/**
 * Account ID class.
 * <p>
 * AccountId class is an identifier to uniquely identify an account. It is numbered at 
 * the time the account is opened. AccountId will not be changed due to a change of branch 
 * office or branch consolidation. It is also used as a key for persistence.
 * Universally Unique Lexicographically Sortable Identifier(ULID) is used AccountId.
 * 
 * <p>
 * 口座識別子クラス
 * <p>
 * 口座をユニークに識別するための識別子を表すクラスです。口座識別子は、口座開設時に採番されます。
 * 取引店変更や店舗統廃合によって変更されることはありません。また、永続化のためのキーとして使用されます。
 * 口座識別子としてUniversally Unique Lexicographically Sortable Identifier(ULID)を使用します。
 * 
 */

public class AccountId {

    /* 口座識別子 */
    private String accountId;

    /**
     * コンストラクター。
     * 
     * <p>
     * 指定された口座識別子でインスタンスを生成します。
     * 
     * @param accountId 口座識別子
     */
    public AccountId(String accountId) {
        this.setAccountId(accountId);
    }

    /**
     * デフォルトコンストラクター
     * 
     * <p>
     * 口座識別子は26桁のCrockford Base32された文字列です。AccountIdが無指定のときは初期値として
     * 26桁の0(ゼロ)を設定します。
     */
    public AccountId() {
        this("00000000000000000000000000");
    }

    /**
     * 口座識別子を取得する。
     * 
     * <p>
     * インスタンスが持つ口座識別子を取得します。
     * 
     * @return 口座識別子
     */
    public String getAccountId() {
        return this.accountId;
    }
    /**
     * 口座識別子を設定する。
     * 
     * <p>
     * インスタンスに口座識別子を設定します。
     * 
     * @param accountId 口座識別子
     * @throws IllegalArgumentException 口座識別子が26桁のCrockford Base32文字列でないとき
     */
    public void setAccountId(String accountId) {
        if (accountId == null) {
            throw new IllegalArgumentException("口座識別子は26桁の文字列でなくてはならない");
        } else {
            /* 口座識別子はULIDです。ULIDはCrockford Base32(0〜9とI, L, O, Uを除く大文字英字)でエンコードされた文字列です。*/
            if (accountId.matches("[0-9A-HJKMNP-TV-Z]{26}")) {  // 26桁の文字列？
                this.accountId = accountId;
            } else {
                throw new IllegalArgumentException("口座識別子は26桁の文字列でなくてはならない");
            }
        }
    }

    /**
     * 口座識別子を生成する
     * 
     * <p>
     * ULIDを生成し、口座識別子として設定します。
     * 
     * @return 口座識別子
     */
    public void generateAccountId() {
        this.setAccountId(ULID.generate());
    }
    /**
     * 文字列表現
     * 
     * <P>
     * インスタンスの文字列表現メソッドです。インスタンスが保持している口座識別子を返します。
     * 
     * @return 口座識別子
     */
    @Override
    public String toString() {
        return "口座識別子: " + this.accountId;
    }

    /**
     * 等価判定
     * 
     * <P>インスタンスの等価判定メソッドです。インスタンスが等価であるか否かをbooleanで返します。
     * 口座識別子が一致するとき等価であると判定します。
     * 
     * @return true 等価である
     * @return false 等価でない
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof AccountId) { //比較対象はAccountIdクラスのインスタンス?
            if (o == this) {
                return true;
            } else {
                AccountId a = (AccountId)o;
                if (this.accountId.equals(a.accountId)) { //口座識別子が一致する?
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
    @Override
    public int hashCode() {
        return Objects.hash(this.accountId);
    }

    /**
     * 大小関係を判定する
     * 
     * <p>インスタンスの大小関係を判定し結果を返します。大小関係の判定は口座識別子で行います。
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
    @Override
    public AccountId clone() {
        return new AccountId(this.accountId);
    }
}