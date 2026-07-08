package org.dreeam.leaf.config.modules.gameplay;

import org.dreeam.leaf.config.ConfigModules;
import org.dreeam.leaf.config.EnumConfigCategory;

public class AlwaysHighRewardEnderDragonFight extends ConfigModules {

    public String getBasePath() {
        return EnumConfigCategory.GAMEPLAY.getBaseKeyName();
    }

    public static boolean enabled = false;

    @Override
    public void onLoaded() {
        enabled = config.getBoolean(getBasePath() + ".always-high-reward-ender-dragon-fight", enabled,
            config.pickStringRegionBased(
                "Treat every ender dragon fight as the first kill for high rewards.",
                "每次末影龙战斗都按首次击杀结算高收益。"
            ));
    }
}
