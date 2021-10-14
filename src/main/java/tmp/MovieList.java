package tmp;

public class MovieList {
    private int numberLikes;
    private int numberNoLikes;
    private float totalRating;
    private int idList;
    private String usernameOwner;
    private String typeList;

    public int getNumberLikes() {
        return numberLikes;
    }

    public void setNumberLikes(int numberLikes) {
        this.numberLikes = numberLikes;
    }

    public int getNumberNoLikes() {
        return numberNoLikes;
    }

    public void setNumberNoLikes(int numberNoLikes) {
        this.numberNoLikes = numberNoLikes;
    }

    public float getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(float totalRating) {
        this.totalRating = totalRating;
    }

    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }

    public String getUsernameOwner() {
        return usernameOwner;
    }

    public void setUsernameOwner(String usernameOwner) {
        this.usernameOwner = usernameOwner;
    }

    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }
}
