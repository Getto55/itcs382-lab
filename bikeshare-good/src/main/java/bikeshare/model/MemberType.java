package bikeshare.model;

public enum MemberType {
    STUDENT(2),
    STAFF(3);

    private final int ratePerMinute;

    MemberType(int ratePerMinute) {
        this.ratePerMinute = ratePerMinute;
    }

    public int getRatePerMinute() {
        return ratePerMinute;
    }
}