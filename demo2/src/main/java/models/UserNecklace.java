package models;

public class UserNecklace {
    int userId;
    int necklaceId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNecklaceId() {
        return necklaceId;
    }

    public void setNecklaceId(int necklaceId) {
        this.necklaceId = necklaceId;
    }

    public UserNecklace(int userId, int necklaceId) {
        this.userId = userId;
        this.necklaceId = necklaceId;
    }
}
