package sample.datamodels;

public class Profile {
    private String shortDescription;
    private String profileImage;
    private String profileCover;
    private String skills;

    public Profile() {
        shortDescription  = "Hi, this is my profile's short description";
        profileImage = "- My profile image";
        profileCover = "- My image cover";
        skills  = "- My skills";
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileCover() {
        return profileCover;
    }

    public void setProfileCover(String profileCover) {
        this.profileCover = profileCover;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
