package xyz.geik.farmer.modules.autoseller;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import xyz.geik.farmer.Main;
import xyz.geik.farmer.modules.FarmerModule;
import xyz.geik.farmer.modules.autoseller.configuration.ConfigFile;
import xyz.geik.farmer.modules.autoseller.handlers.AutoSellerEvent;
import xyz.geik.farmer.modules.autoseller.handlers.AutoSellerGuiCreateEvent;
import xyz.geik.glib.GLib;
import xyz.geik.glib.chat.ChatUtils;
import xyz.geik.glib.shades.okaeri.configs.ConfigManager;
import xyz.geik.glib.shades.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * AutoSeller module main class
 * @author Geik
 */
@Getter
public class AutoSeller extends FarmerModule {

    public AutoSeller() {}

    @Getter
    private static AutoSeller instance;

    private static AutoSellerEvent autoSellerEvent;

    private static AutoSellerGuiCreateEvent autoSellerGuiCreateEvent;

    private final List<String> allowedItems = new ArrayList<>();

    private String customPerm = "farmer.autoseller";

    private boolean defaultStatus = false;

    private ConfigFile configFile;

    /**
     * onEnable method of module
     */
    @Override
    public void onEnable() {
        instance = this;
        this.setLang(Main.getConfigFile().getSettings().getLang(), this.getClass());
        setupFile();

        if (configFile.isStatus()) {
            this.setHasGui(true);
            autoSellerEvent = new AutoSellerEvent();
            autoSellerGuiCreateEvent = new AutoSellerGuiCreateEvent();
            Bukkit.getPluginManager().registerEvents(autoSellerEvent, Main.getInstance());
            Bukkit.getPluginManager().registerEvents(autoSellerGuiCreateEvent, Main.getInstance());
            getAllowedItems().addAll(configFile.getItems());
            customPerm = configFile.getCustomPerm();
            defaultStatus = configFile.isDefaultStatus();
            String messagex = "&3[" + GLib.getInstance().getName() + "] &a" + getName() + " enabled.";
            ChatUtils.sendMessage(Bukkit.getConsoleSender(), messagex);
        }
        else {
            String messagex = "&3[" + GLib.getInstance().getName() + "] &c" + getName() + " is not loaded.";
            ChatUtils.sendMessage(Bukkit.getConsoleSender(), messagex);
        }
    }

    /**
     * onReload method of module
     */
    @Override
    public void onReload() {
        if (!this.isEnabled())
            return;
        if (!getAllowedItems().isEmpty())
            getAllowedItems().clear();
        getAllowedItems().addAll(this.getConfigFile().getItems());
        customPerm = this.getConfigFile().getCustomPerm();
        defaultStatus = this.getConfigFile().isDefaultStatus();
    }

    /**
     * onDisable method of module
     */
    @Override
    public void onDisable() {
        HandlerList.unregisterAll(autoSellerEvent);
        HandlerList.unregisterAll(autoSellerGuiCreateEvent);
    }

    public void setupFile() {
        configFile = ConfigManager.create(ConfigFile.class, (it) -> {
            it.withConfigurer(new YamlBukkitConfigurer());
            it.withBindFile(new File(Main.getInstance().getDataFolder(), String.format("/modules/%s/config.yml", getName().toLowerCase())));
            it.saveDefaults();
            it.load(true);
        });
    }
}
