package com.cocreativeds;
/**
 * 銀行口座を表すクラス
 * 
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

    /**
     * コンストラクター
     */
    public Account(String bc, String bo, String at, String an, String aid) {
        this.setBankCode(bc);
        this.setBranchOfficeNumber(bo);
        this.setAccountTypeCode(at);
        this.setAccountNumber(an);
        this.setAccountId(aid);
    }

    /**
     * デフォルトコンストラクター
     */
    public Account() {
        this.bankCode = new BankCode();
        this.branchOfficeNumber = new BranchOfficeNumber();
        this.accountTypeCode = new AccountTypeCode();
        this.accountNumber = new AccountNumber();
    }
    /**
     * 口座残高を照会する
     * @return 口座残高
     */
    public long getBalance() {
        return this.balance;
    }

    /**
     * 金融機関コードを設定する
     * @param bc 金融機関コード
     */
    public void setBankCode(String bc) {
        this.bankCode = new BankCode(bc);
    }

    /**
     * 店番を設定する
     * @param bo 店番
     */
    public void setBranchOfficeNumber(String bo) {
        this.branchOfficeNumber = new BranchOfficeNumber(bo);
    }

    /**
     * 預金種目コードを設定する
     * @param at 預金種目コード
     */
    public void setAccountTypeCode(String at) {
        this.accountTypeCode = new AccountTypeCode(at);
    }

    /**
     * 口座番号を設定する
     * @param an 口座番号
     */
    public void setAccountNumber(String an) {
        this.accountNumber = new AccountNumber(an);
    }

    /**
     * 口座識別子を設定する
     * @param aid 口座識別子
     */
    public void setAccountId(String aid) {
        this.accountNumber = new AccountNumber(aid);
    }

    /**
     * 文字列表現
     * @return 金融機関コード、店番、預金種目、口座番号、口座識別子
     */
    public String toString() {
        return "口座: " + this.bankCode.getBankCode() + "-" 
        + this.branchOfficeNumber.getBranchOfficeNumber() + "-"
        + this.accountTypeCode.getAccountTypeCode() + "-"
        + this.accountNumber.getAccountNumber() + "-"
        + this.accountId.getAccountId();
    }
}
