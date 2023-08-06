package leetcode_questions.companies.jpm;

public class _JPM_780_Reaching_Points {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx < sx || ty < sy) return false;
        if (sx == tx) return (ty - sy) % sx == 0;
        if (sy == ty) return (tx - sx) % sy == 0;
        if (tx > ty) {
            return reachingPoints(sx, sy, tx % ty, ty);
        } else if (tx < ty) {
            return reachingPoints(sx, sy, tx, ty % tx);
        } else {
            return false;
        }
    }
}
