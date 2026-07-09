package org.dreeam.leaf.config.modules.fixes;

import org.dreeam.leaf.config.ConfigModules;
import org.dreeam.leaf.config.EnumConfigCategory;

public class CollisionBehaviour extends ConfigModules {

    public String getBasePath() {
        return EnumConfigCategory.FIXES.getBaseKeyName() + ".collision-behaviour";
    }

    public static CollisionMode collisionMode = CollisionMode.PAPER;

    public enum CollisionMode {
        VANILLA, PAPER
    }

    @Override
    public void onLoaded() {
        config.addCommentRegionBased(getBasePath(),
            "Collision behaviour mode.",
            "碰撞行为模式。"
        );

        String raw = config.getString(getBasePath() + ".mode", collisionMode.name(), config.pickStringRegionBased(
            "Collision behaviour mode: VANILLA (strict intersection, no epsilon) or PAPER (epsilon-based intersection).",
            "碰撞行为模式：VANILLA（严格相交判定，无容差）或 PAPER（基于 epsilon 的容差判定）。"
        ));

        try {
            collisionMode = CollisionMode.valueOf(raw.toUpperCase());
        } catch (IllegalArgumentException e) {
            collisionMode = CollisionMode.PAPER;
        }
    }
}
