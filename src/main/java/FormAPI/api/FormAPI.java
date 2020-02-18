package FormAPI.api;

import cn.nukkit.form.window.FormWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormAPI implements FormImpl {

    protected static List<Map<String, FormWindow>> formWindowList = new ArrayList<>();

    public FormWindow get(String name) {
        FormWindow window = null;
        for (int i = 0; i < formWindowList.size(); i++){
            Map<String, FormWindow> formWindowMap = formWindowList.get(i);
            if (formWindowMap.containsKey(name)) {
                window = this.get(i);
            }
        }
        return window;
    }

    public FormWindow get(int id) {
        FormWindow window = null;
        Map<String, FormWindow> formWindowMap = formWindowList.get(id);
        for (FormWindow formWindow : formWindowMap.values()) {
            window = formWindow;
        }
        return window;
    }

    public int getId(String name) {
        int id = -1;
        for (int i = 0; i < formWindowList.size(); i++){
            Map<String, FormWindow> formWindowMap = formWindowList.get(i);
            if (formWindowMap.containsKey(name)) {
                id = i;
            }
        }
        return id;
    }

    public void add(String name, FormWindow formWindow) {
        Map<String, FormWindow> formWindowMap = new HashMap<>();
        formWindowMap.put(name, formWindow);

        if (this.get(name) != null) {
            formWindowList.add(formWindowMap);
        } else {
            formWindowList.add(this.getId(name), formWindowMap);
        }

    }

}
