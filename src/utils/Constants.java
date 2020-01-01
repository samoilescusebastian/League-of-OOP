package utils;

import location.Point;

public final class Constants {
    private Constants() {
    }
    public static final int ZERO = 0;
    public static final int FB_DAMAGE = 350;
    public static final int FB_DMG_PER_LVL = 50;

    public static final int IG_BASE_DAMAGE = 150;
    public static final int IG_BASE_PER_LVL = 20;
    public static final int IG_ROUND_DAMAGE = 50;
    public static final int IG_ROUND_PER_LVL = 30;

    public static final int EX_DAMAGE = 200;
    public static final int EX_DMG_PER_LVL = 30;
    public static final float EX_PROC_HP = 0.2f;
    public static final float EX_PROC_HP_PER_LVL = 0.01f;
    public static final float EX_PROC_HP_LIMIT = 0.4f;

    public static final int SL_BASE_DAMAGE = 100;
    public static final int SL_BASE_PER_LVL = 40;

    public static final float DR_HP_PROC = 0.2f;
    public static final float DR_PROC_PER_LEVEL = 0.05f;

    public static final float DF_PROC = 0.35f;
    public static final float DF_PROC_PER_LVL = 0.02f;
    public static final float DF_LIMIT = 0.7f;

    public static final int BS_DAMAGE = 200;
    public static final int BS_DMG_PER_LVL = 20;

    public static final int PL_DAMAGE = 40;
    public static final int PL_PER_LVL = 10;

    public static final int PYRO_INIT_HP = 500;
    public static final int PYRO_HP_PER_LVL = 50;

    public static final int KG_INIT_HP = 900;
    public static final int KG_HP_PER_LVL = 80;

    public static final int WIZ_INIT_HP = 400;
    public static final int WIZ_HP_PER_LVL = 30;

    public static final int ROG_INIT_HP = 600;
    public static final int ROG_HP_PER_LVL = 40;


    public static final float LAND_BONUS = 0.15f;
    public static final float VOLCANIC_BONUS = 0.25f;
    public static final float DESERT_BONUS = 0.10f;
    public static final float WOODS_BONUS = 0.15f;

    public static final int IG_DMG_LIFE = 2;
    public static final int ONE = 1;
    public static final int FULL_PERCENTAGE = 100;
    public static final float FULL_DMG = 1f;
    public static final int XP_REF = 200;
    public static final int XP_AMP = 40;
    public static final int LVL_UP_XP_BASE = 250;
    public static final int LVL_UP_AMP = 50;
    public static final int PL_OVERTIME = 3;
    public static final float AMPLIFIER = 1.5f;
    public static final float DR_HP_DEP = 0.3f;
    public static final int OVERTIME_BONUS = 3;
    public static final int NEUTRAL = 1;
    public static final int NO_EFFECT = -1;

    public static final float FB_ROGUE_BONUS = -0.2f;
    public static final float FB_KNIGHT_BONUS = 0.2f;
    public static final float FB_PYRO_BONUS = -0.10f;
    public static final float FB_WIZARD_BONUS = 0.05f;

    public static final float IG_ROGUE_BONUS = -0.2f;
    public static final float IG_KNIGHT_BONUS = 0.2f;
    public static final float IG_PYRO_BONUS = -0.10f;
    public static final float IG_WIZARD_BONUS = 0.05f;

    public static final float EX_ROGUE_BONUS = 0.15f;
    public static final float EX_KNIGHT_BONUS = 0.0f;
    public static final float EX_PYRO_BONUS = 0.10f;
    public static final float EX_WIZARD_BONUS = -0.20f;

    public static final float SL_ROGUE_BONUS = -0.2f;
    public static final float SL_KNIGHT_BONUS = 0.2f;
    public static final float SL_PYRO_BONUS = -0.10f;
    public static final float SL_WIZARD_BONUS = 0.05f;
    public static final int SL_PARALYSIS = 1;

    public static final float DR_ROGUE_BONUS = -0.2f;
    public static final float DR_KNIGHT_BONUS = 0.2f;
    public static final float DR_PYRO_BONUS = -0.10f;
    public static final float DR_WIZARD_BONUS = 0.05f;

    public static final float DF_ROGUE_BONUS = 0.2f;
    public static final float DF_KNIGHT_BONUS = 0.4f;
    public static final float DF_PYRO_BONUS = 0.30f;

    public static final float BS_ROGUE_BONUS = 0.20f;
    public static final float BS_KNIGHT_BONUS = -0.10f;
    public static final float BS_PYRO_BONUS = 0.25f;
    public static final float BS_WIZARD_BONUS = 0.25f;
    public static final int BS_CRITICAL_LOAD_FACTOR = 3;

    public static final float PL_ROGUE_BONUS = -0.10f;
    public static final float PL_KNIGHT_BONUS = -0.20f;
    public static final float PL_PYRO_BONUS = 0.20f;
    public static final float PL_WIZARD_BONUS = 0.25f;

    public static final int KNIGHT_INF_HP = 3;
    public static final int KNIGHT_SUP_HP = 2;
    public static final int PYRO_INF_HP = 4;
    public static final int PYRO_SUP_HP = 4;
    public static final int ROGUE_INF_HP = 7;
    public static final int ROGUE_SUP_HP = 5;
    public static final int WIZARD_INF_HP = 4;
    public static final int WIZARD_SUP_HP = 2;

    public static final int KNIGHT_HP_SUPPLY = 4;
    public static final int KNIGHT_HP_STRIP = -5;
    public static final float KNIGHT_ABILITIES_SUPPLY = 0.5f;
    public static final float KNIGHT_ABILITIES_STRIP = -0.2f;
    public static final int PYRO_HP_SUPPLY = 3;
    public static final int PYRO_HP_STRIP = -4;
    public static final float PYRO_ABILITIES_SUPPLY = 0.7f;
    public static final float PYRO_ABILITIES_STRIP = -0.3f;
    public static final int ROGUE_HP_SUPPLY = 2;
    public static final int ROGUE_HP_STRIP = -7;
    public static final float ROGUE_ABILITIES_SUPPLY = 0.4f;
    public static final float ROGUE_ABILITIES_STRIP = -0.1f;
    public static final int WIZARD_HP_SUPPLY = 5;
    public static final int WIZARD_HP_STRIP = -10;
    public static final float WIZARD_ABILITIES_SUPPLY = 0.6f;
    public static final float WIZARD_ABILITIES_STRIP = -0.2f;

    public static final float KNIGHT_DMG_ANGEL_MODIFIER = 0.15f;
    public static final float PYRO_DMG_ANGEL_MODIFIER = 0.2f;
    public static final float ROGUE_DMG_ANGEL_MODIFIER = 0.3f;
    public static final float WIZARD_DMG_ANGEL_MODIFIER = 0.4f;

    public static final int KNIGHT_DARK_ANGEL_MODIFIER = -40;
    public static final int PYRO_DARK_ANGEL_MODIFIER = -30;
    public static final int ROGUE_DARK_ANGEL_MODIFIER = -10;
    public static final int WIZARD_DARK_ANGEL_MODIFIER = -20;

    public static final float KNIGHT_DMG_DRACULA_MODIFIER = -0.2f;
    public static final float PYRO_DMG_DRACULA_MODIFIER = -0.3f;
    public static final float ROGUE_DMG_DRACULA_MODIFIER = -0.1f;
    public static final float WIZARD_DMG_DRACULA_MODIFIER = -0.4f;

    public static final int KNIGHT_HP_DRACULA_MODIFIER = -60;
    public static final int PYRO_HP_DRACULA_MODIFIER = -40;
    public static final int ROGUE_HP_DRACULA_MODIFIER = -35;
    public static final int WIZARD_HP_DRACULA_MODIFIER = -20;

    public static final float KNIGHT_DMG_GOODBOY_MODIFIER = 0.4f;
    public static final float PYRO_DMG_GOODBOY_MODIFIER = 0.5f;
    public static final float ROGUE_DMG_GOODBOY_MODIFIER = 0.4f;
    public static final float WIZARD_DMG_GOODBOY_MODIFIER = 0.3f;

    public static final int KNIGHT_HP_GOODBOY_MODIFIER = 20;
    public static final int PYRO_HP_GOODBOY_MODIFIER = 30;
    public static final int ROGUE_HP_GOODBOY_MODIFIER =  40;
    public static final int WIZARD_HP_GOODBOY_MODIFIER = 50;

    public static final float KNIGHT_DMG_LU_ANGEL_MODIFIER = 0.1f;
    public static final float PYRO_DMG_LU_ANGEL_MODIFIER = 0.2f;
    public static final float ROGUE_DMG_LU_ANGEL_MODIFIER = 0.1499999f;
    public static final float WIZARD_DMG_LU_ANGEL_MODIFIER = 0.25f;

    public static final int KNIGHT_LIFE_GIVER_ANGEL_MODIFIER = 100;
    public static final int PYRO_LIFE_GIVER_ANGEL_MODIFIER = 80;
    public static final int ROGUE_LIFE_GIVER_ANGEL_MODIFIER = 90;
    public static final int WIZARD_LIFE_GIVER_ANGEL_MODIFIER = 120;

    public static final float KNIGHT_DMG_S_ANGEL_MODIFIER = 0.1f;
    public static final float PYRO_DMG_S_ANGEL_MODIFIER = 0.15f;
    public static final float ROGUE_DMG_S_ANGEL_MODIFIER = 0.05f;
    public static final float WIZARD_DMG_S_ANGEL_MODIFIER = 0.10f;

    public static final int KNIGHT_HP_S_ANGEL_MODIFIER = 10;
    public static final int PYRO_HP_S_ANGEL_MODIFIER = 15;
    public static final int ROGUE_HP_S_ANGEL_MODIFIER = 20;
    public static final int WIZARD_HP_S_ANGEL_MODIFIER = 25;

    public static final int KNIGHT_HP_SPAWNER_MODIFIER = 200;
    public static final int PYRO_HP_SPAWNER_MODIFIER = 150;
    public static final int ROGUE_HP_SPAWNER_MODIFIER = 180;
    public static final int WIZARD_HP_SPAWNER_MODIFIER = 120;

    public static final int KNIGHT_XP_ANGEL_MODIFIER = 45;
    public static final int PYRO_XP_ANGEL_MODIFIER = 50;
    public static final int ROGUE_XP_ANGEL_MODIFIER = 40;
    public static final int WIZARD_XP_ANGEL_MODIFIER = 60;

    public static final String HELPED = "helped";
    public static final String HIT = "hit";


    public static final Point UP = new Point(-1, 0);
    public static final Point DOWN = new Point(1, 0);
    public static final Point LEFT = new Point(0, -1);
    public static final Point RIGHT = new Point(0, 1);



}
