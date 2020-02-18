# FormAPI for NukkitX

###### Keep track of form sending from multiple plugins...

### API documentation

 + init FormAPI in Main class
```java

package org.example;

import FormAPI.api.FormAPI;

public class Main extends PluginBase {
    
    public FormAPI formAPI = new FormAPI();

    @Override
    public void onEnable() {
    }  

}
```

 + Create form
```java
FormWindow window = new FormWindowSimple("title", "content");
```

 + add form to formAPI
```java
formAPI.add("name", window);
```

 + send form to player
 ```java
// this MUST be called after adding the form to FormAPI instance because "formAPI.add(...)" creates the id that we need to use here
player.showFormWindow(formAPI.get("name"), formAPI.getId("name"));
```

+ handle form response
```java
public class ExampleEvent implements Listener {
    
    // main class where FormAPI property is set
    private Main plugin;    

    // don't forget to register this event in "onEnable"
    public ExampleEvent(Main plugin) {
        this.plugin = plugin;
    }   

    @EventHandler()
    public void onEvent(PlayerFormRespondedEvent event) {

        // simply check for the form id and bam! its that easy...
        if (event.getFormId() == plugin.formAPI.getId("name")){
            
        }

    }

}
```
