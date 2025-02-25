package com.simibubi.create.foundation.config;

import com.simibubi.create.foundation.config.ui.ConfigAnnotations;

public class CKinetics extends ConfigBase {

	public ConfigBool disableStress = b(false, "disableStress", Comments.disableStress);
	public ConfigInt maxBeltLength = i(20, 5, "maxBeltLength", Comments.maxBeltLength);
	public ConfigInt crushingDamage = i(4, 0, "crushingDamage", Comments.crushingDamage);
	public ConfigInt maxMotorSpeed = i(256, 64, "maxMotorSpeed", Comments.rpm, Comments.maxMotorSpeed, ConfigAnnotations.RequiresRestart.BOTH.asComment());
	public ConfigInt waterWheelBaseSpeed = i(4, 1, "waterWheelBaseSpeed", Comments.rpm, Comments.waterWheelBaseSpeed);
	public ConfigInt waterWheelFlowSpeed = i(4, 1, "waterWheelFlowSpeed", Comments.rpm, Comments.waterWheelFlowSpeed);
	public ConfigInt furnaceEngineSpeed = i(16, 1, "furnaceEngineSpeed", Comments.rpm, Comments.furnaceEngineSpeed);
	public ConfigInt maxRotationSpeed = i(256, 64, "maxRotationSpeed", Comments.rpm, Comments.maxRotationSpeed);
	public ConfigEnum<DeployerAggroSetting> ignoreDeployerAttacks =
		e(DeployerAggroSetting.CREEPERS, "ignoreDeployerAttacks", Comments.ignoreDeployerAttacks);
	public ConfigInt kineticValidationFrequency =
		i(60, 5, "kineticValidationFrequency", Comments.kineticValidationFrequency);
	public ConfigFloat crankHungerMultiplier = f(.01f, 0, 1, "crankHungerMultiplier", Comments.crankHungerMultiplier);
	public ConfigInt minimumWindmillSails = i(8, 0, "minimumWindmillSails", Comments.minimumWindmillSails);
	public ConfigInt windmillSailsPerRPM = i(8, 1, "windmillSailsPerRPM", Comments.windmillSailsPerRPM);
	public ConfigInt maxEjectorDistance = i(32, 0, "maxEjectorDistance", Comments.maxEjectorDistance);
	public ConfigInt ejectorScanInterval = i(120, 10, "ejectorScanInterval", Comments.ejectorScanInterval);

	public ConfigGroup fan = group(1, "encasedFan", "Encased Fan");
	public ConfigInt fanPushDistance = i(20, 5, "fanPushDistance", Comments.fanPushDistance);
	public ConfigInt fanPullDistance = i(20, 5, "fanPullDistance", Comments.fanPullDistance);
	public ConfigInt fanBlockCheckRate = i(30, 10, "fanBlockCheckRate", Comments.fanBlockCheckRate);
	public ConfigInt fanRotationArgmax = i(256, 64, "fanRotationArgmax", Comments.rpm, Comments.fanRotationArgmax);
	public ConfigInt generatingFanSpeed = i(4, 0, "generatingFanSpeed", Comments.rpm, Comments.generatingFanSpeed);
	public ConfigInt inWorldProcessingTime = i(150, 0, "inWorldProcessingTime", Comments.inWorldProcessingTime);

	public ConfigGroup contraptions = group(1, "contraptions", "Moving Contraptions");
	public ConfigInt maxBlocksMoved = i(2048, 1, "maxBlocksMoved", Comments.maxBlocksMoved);
	public ConfigInt maxChassisRange = i(16, 1, "maxChassisRange", Comments.maxChassisRange);
	public ConfigInt maxPistonPoles = i(64, 1, "maxPistonPoles", Comments.maxPistonPoles);
	public ConfigInt maxRopeLength = i(128, 1, "maxRopeLength", Comments.maxRopeLength);
	public ConfigInt maxCartCouplingLength = i(32, 1, "maxCartCouplingLength", Comments.maxCartCouplingLength);
	public ConfigEnum<SpawnerMovementSetting> spawnerMovement =
			e(SpawnerMovementSetting.NO_PICKUP, "movableSpawners", Comments.spawnerMovement);
	public ConfigBool moveItemsToStorage = b(true, "moveItemsToStorage", Comments.moveItemsToStorage);
	public ConfigBool harvestPartiallyGrown = b(false, "harvestPartiallyGrown", Comments.harvestPartiallyGrown);
	public ConfigBool harvesterReplants = b(true, "harvesterReplants", Comments.harvesterReplants);

	public CStress stressValues = nested(1, CStress::new, Comments.stress);

	public ConfigGroup state = group(1, "stats", Comments.stats);
	public ConfigFloat mediumSpeed = f(30, 0, 4096, "mediumSpeed", Comments.rpm, Comments.mediumSpeed);
	public ConfigFloat fastSpeed = f(100, 0, 65535, "fastSpeed", Comments.rpm, Comments.fastSpeed);
	public ConfigFloat mediumStressImpact =
		f(4, 0, 4096, "mediumStressImpact", Comments.su, Comments.mediumStressImpact);
	public ConfigFloat highStressImpact = f(8, 0, 65535, "highStressImpact", Comments.su, Comments.highStressImpact);
	public ConfigFloat mediumCapacity = f(128, 0, 4096, "mediumCapacity", Comments.su, Comments.mediumCapacity);
	public ConfigFloat highCapacity = f(512, 0, 65535, "highCapacity", Comments.su, Comments.highCapacity);

	@Override
	public String getName() {
		return "kinetics";
	}

	private static class Comments {
		static String maxBeltLength = "Maximum length in blocks of mechanical belts.";
		static String crushingDamage = "Damage dealt by active Crushing Wheels.";
		static String maxMotorSpeed = "Maximum allowed speed of a configurable motor.";
		static String maxRotationSpeed = "Maximum allowed rotation speed for any Kinetic Tile.";
		static String fanPushDistance = "Maximum distance in blocks Fans can push entities.";
		static String fanPullDistance = "Maximum distance in blocks from where Fans can pull entities.";
		static String fanBlockCheckRate = "Game ticks between Fans checking for anything blocking their air flow.";
		static String fanRotationArgmax = "Rotation speed at which the maximum stats of fans are reached.";
		static String generatingFanSpeed = "Rotation speed generated by a vertical fan above fire.";
		static String inWorldProcessingTime = "Game ticks required for a Fan-based processing recipe to take effect.";
		static String crankHungerMultiplier =
			"multiplier used for calculating exhaustion from speed when a crank is turned.";
		static String maxBlocksMoved =
			"Maximum amount of blocks in a structure movable by Pistons, Bearings or other means.";
		static String maxChassisRange = "Maximum value of a chassis attachment range.";
		static String maxPistonPoles = "Maximum amount of extension poles behind a Mechanical Piston.";
		static String maxRopeLength = "Max length of rope available off a Rope Pulley.";
		static String maxCartCouplingLength = "Maximum allowed distance of two coupled minecarts.";
		static String moveItemsToStorage =
			"Whether items mined or harvested by contraptions should be placed in their mounted storage.";
		static String harvestPartiallyGrown = "Whether harvesters should break crops that aren't fully grown.";
		static String harvesterReplants = "Whether harvesters should replant crops after harvesting.";
		static String stats = "Configure speed/capacity levels for requirements and indicators.";
		static String rpm = "[in Revolutions per Minute]";
		static String su = "[in Stress Units]";
		static String mediumSpeed = "Minimum speed of rotation to be considered 'medium'";
		static String fastSpeed = "Minimum speed of rotation to be considered 'fast'";
		static String mediumStressImpact = "Minimum stress impact to be considered 'medium'";
		static String highStressImpact = "Minimum stress impact to be considered 'high'";
		static String mediumCapacity = "Minimum added Capacity by sources to be considered 'medium'";
		static String highCapacity = "Minimum added Capacity by sources to be considered 'high'";
		static String stress = "Fine tune the kinetic stats of individual components";
		static String ignoreDeployerAttacks = "Select what mobs should ignore Deployers when attacked by them.";
		static String waterWheelBaseSpeed = "Added rotation speed by a water wheel when at least one flow is present.";
		static String waterWheelFlowSpeed =
			"Rotation speed gained by a water wheel for each side with running fluids. (halved if not against blades)";
		static String furnaceEngineSpeed = "Base rotation speed for the furnace engine generator";
		static String disableStress = "Disable the Stress mechanic altogether.";
		static String kineticValidationFrequency =
			"Game ticks between Kinetic Blocks checking whether their source is still valid.";
		static String minimumWindmillSails =
			"Amount of sail-type blocks required for a windmill to assemble successfully.";
		static String windmillSailsPerRPM = "Number of sail-type blocks required to increase windmill speed by 1RPM.";
		static String maxEjectorDistance = "Max Distance in blocks a Weighted Ejector can throw";
		static String ejectorScanInterval =
			"Time in ticks until the next item launched by an ejector scans blocks for potential collisions";
		static String spawnerMovement = "Configure how Spawner blocks can be moved by contraptions.";
	}

	public enum DeployerAggroSetting {
		ALL, CREEPERS, NONE
	}

	public enum SpawnerMovementSetting {
		MOVABLE, NO_PICKUP, UNMOVABLE
	}

}
