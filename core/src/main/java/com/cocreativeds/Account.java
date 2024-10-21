package com.cocreativeds;

import java.time.LocalDate;

/**
 * Account class
 * 
 * <p>
 * This class represents a bank account. This class has the ability to open, close, deposit,  
 * withdrawal, pay interest, view balances, and view deposit and withdrawal statements.
 * A bank account is uniquely identified by an accountId. The accountId is numbered at the time 
 * the account is opened. The accountId is an identifier used within the system and the bank 
 * account holder is unaware of its existence. The bank account holder recognizes the bank 
 * account by its bank code, branch office number, deposit type, and account number. The branch 
 * office number and account number may change due to a change of branch office or consolidation 
 * of branches. The accountId will not be changed by these changes.
 * <p>
 * 銀行口座クラス
 * <p>
 * 銀行口座を表すクラスです。銀行口座は、開設、解約、預け入れ、払い戻し、利息の支払い、残高の照会、入出金明細の照会の
 * 機能を持ちます。銀行口座は、口座識別子によって一意に識別されます。口座識別子は口座開設時に採番されます。
 * 口座識別子は、システム内で使用される識別子であり、銀行口座の保有者はその存在を認識しません。銀行口座は、金融機関
 * コード、店番、預金種目、口座番号を持ちます。銀行口座保有者は金融機関コード、店番、預金種目、口座番号で銀行口座を
 * 認識します。取引店変更や店舗の統廃合によって店番や口座番号が変更されることがあります。口座識別子はこれらによって
 * 変更されることはありません。
 */
public class Account {

    /* 金融機関コード */
    private BankCode bankCode;
    /* 店番 */
    private BranchOfficeNumber branchOfficeNumber;
    /* 預金種目コード */
    private AccountTypeCode accountTypeCode;
    /* 口座番号 */
    private AccountNumber accountNumber;
    /* 口座識別子 */
    private AccountId accountId;

    /* 口座残高 */
    private long balance;

    /* 入出金明細 */
    private String[] transactions;

    /**
     * 預金口座のインスタンスを作成する
     * 
     * <p>
     * パラメーターで指示された預金口座のインスタンスを作成します。
     * 
     * @param bankCode 金融機関コード
     * @param boNumber 店番
     * @param accountType 預金種目
     * @param accountNumber 口座番号
     * @param accountId 口座識別子
     */
    public Account(BankCode bankCode, BranchOfficeNumber boNumber, AccountTypeCode accountTypeCode, AccountNumber accountNumber, AccountId accountId) {
        this.bankCode = bankCode;
        this.branchOfficeNumber = boNumber;
        this.accountTypeCode = accountTypeCode;
        this.accountNumber = accountNumber;
        this.accountId = accountId;
    }

    /**
     * デフォルトコンストラクター
     * 
     * <p>
     * インスタンス作成後口座開設のメソッドを使用して新規口座を開設する場合に使用します。
     * 
     */
    public Account() {
        this(new BankCode(), 
        new BranchOfficeNumber(), 
        new AccountTypeCode(), 
        new AccountNumber(), 
        new AccountId());
    }

    /**
     * 口座開設
     * <p>
     * 銀行口座を開設します。
     * 
     * @param bankCode 金融機関コード
     * @param boNumber 口座を開設する店舗の店番
     * @param accountTypeCode 預金種目コード
     */
    public void openAccount(BankCode bankCode, BranchOfficeNumber boNumber, AccountTypeCode accountTypeCode) {
        this.bankCode = bankCode;
        this.branchOfficeNumber = boNumber;
        this.accountTypeCode = accountTypeCode;
        this.accountId.generateAccountId(); //口座識別子を採番
        this.accountNumber.generateAccountNumber(); //口座番号を採番
    }

    /**
     * 預け入れ
     * 
     * <p>
     * 口座に資金を預け入れます
     * 
     * @param amount 預け入れする金額
     * @param currency 通貨コード
     * @param trxDate 取引日
     * @param description 摘要
     */
    public void deposit(long amount, String currency, LocalDate trxDate, String description) {

    }

    /**
     * 払い戻し
     * 
     * <p>
     * 口座から資金を払い戻します
     * 
     * @param amount 払い戻す金額
     * @param currency 通貨コード
     * @param trxDate 取引日
     * @param description 摘要
     */
    public void withdrawal(long amount, String currency, LocalDate trxDate, String description) {

    }

    /**
     * 口座残高を照会する
     * @return 口座残高
     */
    public long getBalance() {
        return this.balance;
    }

    /**
     * 取引履歴を照会する
     * 
     * <p>
     * 該当口座に対する照会取引も含むアクセスの履歴を取得します。口座保有者の通帳に印刷する内容とは異なります。
     * 口座保有者の通帳に印刷される内容は、取引履歴から編集して作成します。
     * @param fromDate 取引日の範囲(いつから)
     * @param toDate 取引日の範囲(いつまで)
     * @param maxCount 明細の最大数
     * @param pageSize 
     * @return 取引履歴
     * 取引履歴の内容
     * 取引区分: 預け入れ、払い戻し、通帳記帳、残高照会、入手金明細照会、利息元加
     * 操作日時: 取引を行った日時
     * 取引日: 対顧客上の取引日(通帳に印字される取引の日付。利息計算の基準となる。)
     * 取引金額: 取引の金額
     */
    public String[] getTransactionHistories(LocalDate fromDate, LocalDate toDate) {
        return this.transactions;
    }

    /**
     * 文字列表現
     * @return 金融機関コード、店番、預金種目、口座番号、口座識別子
     */
    @Override
    public String toString() {
        return "口座: " + this.bankCode.getBankCode() + "-" 
        + this.branchOfficeNumber.getBranchOfficeNumber() + "-"
        + this.accountTypeCode.getAccountTypeCode() + "-"
        + this.accountNumber.getAccountNumber() + "-"
        + this.accountId.getAccountId();
    }
}
