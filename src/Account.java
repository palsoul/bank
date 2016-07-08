/**
 * Created by Bauka on 08.07.16.
 */
public class Account {

    private final int id;
    private Integer value;
    private boolean isBlocked;

    public Account() {
        id = -1;
        value = 0;
        isBlocked = true;
    }

    public Account(final int id) {
        this.id = id;
        value = 0;
        isBlocked = false;
    }

    public Account(final int id, int value) {
        this.id = id;
        this.value = value;
        isBlocked = false;
    }

    public Account(final int id, int value, boolean isBlocked) {
        this.id = id;
        this.value = value;
        this.isBlocked = isBlocked;
    }

    public int getId()
    {
        return id;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setBlock(boolean block) {
        isBlocked = block;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}
