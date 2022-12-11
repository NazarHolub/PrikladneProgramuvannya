package models;

public class NecklaceStone {
    int necklaceId;
    int stoneId;

    public int getNecklaceId() {
        return necklaceId;
    }

    public void setNecklaceId(int necklaceId) {
        this.necklaceId = necklaceId;
    }

    public int getStoneId() {
        return stoneId;
    }

    public void setStoneId(int stoneId) {
        this.stoneId = stoneId;
    }

    public NecklaceStone(int necklaceId, int stoneId) {
        this.necklaceId = necklaceId;
        this.stoneId = stoneId;
    }
}
