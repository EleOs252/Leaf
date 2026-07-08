package org.dreeam.leaf.util;

import io.papermc.paper.configuration.GlobalConfiguration;
import io.papermc.paper.configuration.WorldConfiguration;
import io.papermc.paper.configuration.type.number.IntOr;
import java.util.Map;
import org.dreeam.leaf.config.modules.gameplay.McTechnicalSurvivalMode;

public final class McTechnicalModeHelper {

    private McTechnicalModeHelper() {
    }

    public static void applyGlobalConfigOverridesIfEnabled() {
        if (!McTechnicalSurvivalMode.enabled || GlobalConfiguration.get() == null) {
            return;
        }

        GlobalConfiguration.get().unsupportedSettings.allowPistonDuplication = true;
        GlobalConfiguration.get().unsupportedSettings.allowHeadlessPistons = true;
        GlobalConfiguration.get().unsupportedSettings.allowPermanentBlockBreakExploits = true;
        GlobalConfiguration.get().unsupportedSettings.allowUnsafeEndPortalTeleportation = true;
        GlobalConfiguration.get().unsupportedSettings.skipTripwireHookPlacementValidation = true;
        GlobalConfiguration.get().packetLimiter.allPackets = new GlobalConfiguration.PacketLimiter.PacketLimit(
            GlobalConfiguration.get().packetLimiter.allPackets.interval(),
            5000.0,
            GlobalConfiguration.get().packetLimiter.allPackets.action()
        );
        GlobalConfiguration.get().packetLimiter.overrides = Map.of();
        GlobalConfiguration.get().itemValidation.resolveSelectorsInBooks = true;
        GlobalConfiguration.get().scoreboards.saveEmptyScoreboardTeams = true;
    }

    public static void applyWorldConfigOverridesIfEnabled(WorldConfiguration config) {
        if (McTechnicalSurvivalMode.enabled) {
            config.entities.spawning.maxArrowDespawnInvulnerability = IntOr.Disabled.DISABLED;
        }
    }
}
