package db;

import model.IModel;

public interface IDAO <T extends IModel>{
    public int insert(T model);
}
