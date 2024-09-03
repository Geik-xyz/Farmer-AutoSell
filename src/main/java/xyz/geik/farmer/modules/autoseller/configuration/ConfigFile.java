package xyz.geik.farmer.modules.autoseller.configuration;

import lombok.Getter;
import lombok.Setter;
import xyz.geik.farmer.configuration.ModulesFile;
import xyz.geik.glib.shades.okaeri.configs.OkaeriConfig;
import xyz.geik.glib.shades.okaeri.configs.annotation.Comment;
import xyz.geik.glib.shades.okaeri.configs.annotation.NameStrategy;
import xyz.geik.glib.shades.okaeri.configs.annotation.Names;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Modules file
 *
 * @author geik
 * @since 2.0
 */
@Getter
@Setter
@Names(strategy = NameStrategy.IDENTITY)
public class ConfigFile extends OkaeriConfig {

    @Comment({"if you want to enable it, set this to true",
            "this setting will enable the auto-seller",
            "and players with farmer.admin permission can give auto seller.",
            "you can disable buy feature and give farmer with command"})
    private boolean status = false;

    @Comment({"if you want to enable the auto-seller for all players, set this to true",
            "if you want to enable the auto-seller for specific players, set this to false (perm-check)",
            "which replace farmer level same as auto seller level when auto seller level",
            "is higher than farmer level."})
    private boolean defaultStatus = false;

    @Comment({"custom perm only used if defaultStatus is false",
            "only players with this perm will be able to use the auto-seller"})
    private String customPerm = "farmer.autoseller";

    @Comment({"all the items that will be sold by the auto-seller",
            "you can add as many items as you want",
            "the items must be same as the ones in the items.yml of the Farmer",
            "you can also remove this section for enable it to all items"})
    private List<String> items = new ArrayList<>();

}