package dbClasses;

public class Const {
    //user table
    public static final String USER_TABLE = "user";
    public static final String USER_ID = "id";
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";
    //necklace table
    public static final String NECKLACE_TABLE = "necklace";
    public static final String NECKLACE_ID = "id";
    public static final String NECKLACE_NAME = "name";
    //stone table
    public static final String STONE_TABLE = "stone";
    public static final String STONE_ID = "id";
    public static final String STONE_NAME = "name";
    public static final String STONE_CARATS = "carats";
    public static final String STONE_OPACITY = "opacity";
    public static final String STONE_PRICE = "price";
    public static final String STONE_COLOR = "color";
    //user-necklace table
    public static final String USERNECKLACE_TABLE = "usernecklace";
    public static final String USERNECKLACE_USERID = "userId";
    public static final String USERNECKLACE_NECKLACEID = "necklaceId";
    //necklace-stone table
    public static final String NECKLACESTONE_TABLE = "necklacestone";
    public static final String NECKLACESTONE_NECKLACEID = "necklaceId";
    public static final String NECKLACESTONE_STONEID = "stoneId";
}
