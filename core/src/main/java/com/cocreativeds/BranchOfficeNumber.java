package com.cocreativeds;
import java.util.Objects;
/**
 * 店番クラス
 * <p>
 * 店番は、金融機関の店舗を識別する3桁の数字である。
 */
public class BranchOfficeNumber implements Comparable<BranchOfficeNumber>, Cloneable {

    /* 店番 */
    private String branchOfficeNumber;

    /**
     * 店番を設定してインスタンスを生成する
     * @param bo 店番
     */
    public BranchOfficeNumber(String bo) {
        this.setBranchOfficeNumber(bo);
    }

    /**
     * デフォルトコンストラクター
     * <p>
     * 店番として"000"を設定する。
     * 常に"000"を設定するためBranchOfficeNumber(bo)コンストラクターの呼び出しは行わない。
     */
    public BranchOfficeNumber() {
        this.branchOfficeNumber = "000";
    }

    /**
     * 店番を取得する
     * @return 店番
     */
    public String getBranchOfficeNumber() {
        return this.branchOfficeNumber;
    }
    /**
     * 店番を設定する
     * @param bo 店番
     * @throws IllegalArgumentException 店番は3桁の数字でなくてはならない
     */
    public void setBranchOfficeNumber(String bo) {
        if (bo == null) {
            throw new IllegalArgumentException("店番は3桁の数字でなくてはならない");
        } else {
            if (bo.matches("[0-9]{3}")) {  // 3桁の数字？
                this.branchOfficeNumber = bo;
            } else {
                throw new IllegalArgumentException("店番は3桁の数字でなくてはならない");
            }
        }
    }

    /**
     * 文字列表現
     * @return 店番
     */
    public String toString() {
        return "店番: " + this.branchOfficeNumber;
    }

    /**
     * 等価判定
     * @return true 等価である
     * @return false 等価でない
     */
    public boolean equals(Object o) {
        if (o instanceof BranchOfficeNumber) { //比較対象はBranchOfficeNumberクラスのインスタンス?
            if (o == this) {
                return true;
            } else {
                BranchOfficeNumber b = (BranchOfficeNumber)o;
                if (this.branchOfficeNumber.equals(b.branchOfficeNumber)) { //店番が一致する?
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
        return Objects.hash(this.branchOfficeNumber);
    }

    /**
     * 大小関係を判定する
     * @return -1 比較対象が大きい
     * @return 0 比較対象と等しい
     * @return 1 比較対象が小さい
     */
    public int compareTo(BranchOfficeNumber o) {
        return this.branchOfficeNumber.compareTo(o.branchOfficeNumber);
    }

    /**
     * 店番のコピー
     * @return コピーされた店番
     */
    public BranchOfficeNumber clone() {
        return new BranchOfficeNumber(this.branchOfficeNumber);
    }
}
