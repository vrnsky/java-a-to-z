package model;

/**
 * @author evrnsky
 * @version 0.1
 * @since 22.02.2017
 *
 * This is model of role at the system.
 */
public class Role {

    /**
     * Description.
     */
    private String desc;

    /**
     * Default constructor.
     * @param desc desc.
     */
    public Role(String desc) {
        this.desc = desc;
    }

    /**
     * Return description of role.
     * @return desc.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Set new desc.
     * @param desc new version.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Return desc.
     * @return desc.
     */
    @Override
    public String toString() {
        return getDesc();
    }
}
