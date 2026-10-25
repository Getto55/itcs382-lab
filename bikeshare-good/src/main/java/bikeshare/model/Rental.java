package bikeshare.model;

public record Rental(String memberId, MemberType memberType, Bike bike) {
}