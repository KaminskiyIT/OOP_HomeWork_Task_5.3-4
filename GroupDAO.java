package net.ukr.kaminskiy;

public interface GroupDAO {
    public void saveGroup(Group group);

    public Group loadGroup();
}