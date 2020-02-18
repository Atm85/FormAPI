package FormAPI.api;

import cn.nukkit.form.window.FormWindow;

public interface FormImpl {

    FormWindow get(String name);

    FormWindow get(int id);

    int getId(String name);

    void add(String name, FormWindow formWindow);

}
