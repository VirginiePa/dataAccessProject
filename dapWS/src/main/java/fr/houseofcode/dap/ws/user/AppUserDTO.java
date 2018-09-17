package fr.houseofcode.dap.ws.user;

/**
 * @author djer
 *
 */
public class AppUserDTO {

    /** The user "public" ID. */
    private String userId;
    /** The user password. */
    private String password;
    /** The user role. */
    private AppRole role;

    /**
     * Construct a new AppuserDTO with all Datas.
     * @param id   The "public" user id
     * @param pass The user password
     * @param r    The user role
     */
    public AppUserDTO(final String id, final String pass, final AppRole r) {
        this.userId = id;
        this.password = pass;
        this.role = r;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the role
     */
    public AppRole getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(final AppRole role) {
        this.role = role;
    }
}