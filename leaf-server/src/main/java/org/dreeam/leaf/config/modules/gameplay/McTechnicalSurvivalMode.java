package org.dreeam.leaf.config.modules.gameplay;

import org.dreeam.leaf.config.ConfigModules;
import org.dreeam.leaf.config.EnumConfigCategory;

public class McTechnicalSurvivalMode extends ConfigModules {

    public String getBasePath() {
        return EnumConfigCategory.GAMEPLAY.getBaseKeyName();
    }

    public static boolean enabled = false;

    @Override
    public void onLoaded() {
        enabled = config.getBoolean(getBasePath() + ".mc-technical-survival-mode", enabled,
            config.pickStringRegionBased(
                "Enable technical survival compatibility tweaks. Requires server restart to take full effect.",
                "启用技术生存模式兼容调整。需要重启服务器以完全生效。"
            ));
    }
}
