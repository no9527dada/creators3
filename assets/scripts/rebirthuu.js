Blocks.titan.ammoTypes.put(
    Items.tungsten, (() => {
        const D = new JavaAdapter(BasicBulletType, {});
        D.region="shell"
        D.damage = 300;
        D.speed = 2.5
        D.despawnEffect = Fx.none;
        D.knockback = 2;
        D.lifetime = 140;
        D.height = 19;
        D.width = 17;
        D.splashDamageRadius = 65;
        D.splashDamage = 350;
        D.scaledSplashDamage = true;
        D.backColor = D.hitColor = D.trailColor = Color.valueOf("94bff0").lerp(Pal.redLight, 0.5);
        D.frontColor = Color.white;
        D.ammoMultiplier = 1;
        D.hitSound = Sounds.titanExplosion;
        D.status = StatusEffects.blasted;
        D.trailLength = 32;
        D.trailWidth = 3.35;
        D.trailSinScl = 2.5;
        D.trailSinMag = 0.5;
        D.trailEffect = Fx.none;
        D.despawnShake = 7;
        D.shootEffect = Fx.shootTitan;
        D.smokeEffect = Fx.shootSmokeTitan;
        D.trailInterp = v => Math.max(Mathf.slope(v), 0.8);
        D.shrinkX = 0.2;
        D.shrinkY = 0.1;
        D.buildingDamageMultiplier = 0.3;
        return D;
    })());