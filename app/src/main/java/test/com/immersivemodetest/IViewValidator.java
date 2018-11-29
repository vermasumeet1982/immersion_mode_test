package test.com.immersivemodetest;

import java.util.List;


public interface IViewValidator {
    public boolean isViewEmpty(List<String> viewErrors);

    public boolean isViewValid(List<String> viewErrors);

}
