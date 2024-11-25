package Utils;

import java.util.HashMap;
import java.util.Map;

public class HtmlContext {
    private static HtmlContext instance;
    private HtmlElement htmlContent;

    /**
     * idMap存储整个HTML的元素，为避免代码结构的大改，将它集成到HtmlContext类中
     * 提供ID到元素的快速映射，确保ID的唯一性
     * 对HTML进行增、删、改时，需维护 idMap
     */
    private Map<String, HtmlElement> idMap;

    private HtmlContext() {
        this.htmlContent = new HtmlElement(null, "empty", null);
        this.idMap = new HashMap<>();
    }

    public HtmlElement getHtmlContent() {
        return this.htmlContent;
    }

    public void setHtmlContent(HtmlElement content) {
        this.htmlContent = content;
        rebuildIdMap();
    }

    private void rebuildIdMap() {
        idMap.clear();
        buildIdMap(htmlContent);
    }

    private void buildIdMap(HtmlElement element) {
        idMap.put(element.getId(), element);
        for (HtmlElement child : element.getChildren()) {
            buildIdMap(child);
        }
    }

    public HtmlElement getElementById(String id) {
        return idMap.get(id);
    }

    public void addToIdMap(HtmlElement element) {
        if (element == null) return;

        // 检查ID是否已存在
        if (idMap.containsKey(element.getId()) && idMap.get(element.getId()) != element) {
            throw new IllegalStateException("Duplicate ID found: " + element.getId());
        }

        idMap.put(element.getId(), element);
    }

    public void removeFromIdMap(HtmlElement element) {
        if (element == null) return;

        idMap.remove(element.getId());

        // 递归移除所有子元素
        for (HtmlElement child : element.getChildren()) {
            removeFromIdMap(child);
        }
    }

    public void updateElementId(HtmlElement element, String oldId, String newId) {
        if (element == null) return;

        idMap.remove(oldId);
        idMap.put(newId, element);
    }

    // 验证ID是否唯一
    public boolean isIdUnique(String id) {
        return !idMap.containsKey(id);
    }

    public static HtmlContext getInstance() {
        if (instance == null) {
            instance = new HtmlContext();
        }
        return instance;
    }
}