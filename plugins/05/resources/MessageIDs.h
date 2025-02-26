/**
 * @file MessageIDs.h
 *
 * Declaration of ids for debug messages.
 *
 * @author Martin Lötzsch
 */

#pragma once

#include "Streaming/Enum.h"

/**
 * IDs for debug messages
 *
 * To distinguish debug messages, they all have an id.
 */
ENUM(MessageID,
{,
  undefined,
  idFrameBegin,
  idFrameFinished,

  idActivationGraph,
  idAlternativeRobotPoseHypothesis,
  idAnnotation,
  idArmMotionRequest,
  idAudioData,
  idBallModel,
  idBallPercept,
  idBallSpots,
  idBehaviorStatus,
  idBodyContour,
  idCameraCalibration,
  idCameraImage,
  idCameraInfo,
  idCameraMatrix,
  idCirclePercept,
  idFallDownState,
  idFieldBoundary,
  idFieldFeatureOverview,
  idFootOffset,
  idFootSoleRotationCalibration,
  idFootSupport,
  idFrameInfo,
  idFsrData,
  idFsrSensorData,
  idGameControllerData,
  idGameState,
  idGroundContactState,
  idGroundTruthOdometryData,
  idGroundTruthWorldState,
  idIMUCalibration,
  idImageCoordinateSystem,
  idInertialData,
  idInertialSensorData,
  idJointAngles,
  idJointCalibration,
  idJointLimits,
  idJointPlay,
  idJointRequest,
  idJointSensorData,
  idJPEGImage,
  idKeyStates,
  idLabelImage,
  idLinesPercept,
  idMotionInfo,
  idMotionRequest,
  idObstacleModel,
  idObstaclesFieldPercept,
  idObstaclesImagePercept,
  idOdometer,
  idOdometryData,
  idPenaltyMarkPercept,
  idRobotDimensions,
  idRobotHealth,
  idRobotPose,
  idSelfLocalizationHypotheses,
  idSideInformation,
  idStaticJointPoses,
  idStopwatch,
  idStrategyStatus,
  idSystemSensorData,
  idTeamBallModel,
  idTeammatesBallModel,
  idTeamData,
  idThumbnail,
  idWalkGenerator,
  idWalkStepData,
  idWalkingEngineOutput,
  idWalkLearner,
  idWhistle,
  numOfDataMessageIDs, /**< everything below this does not belong into log files */

  // infrastructure
  idRobot = numOfDataMessageIDs,
  idConsole,
  idDebugDataChangeRequest,
  idDebugDataResponse,
  idDebugDrawing,
  idDebugDrawing3D,
  idDebugImage,
  idDebugRequest,
  idDebugResponse,
  idDrawingManager,
  idDrawingManager3D,
  idLogResponse,
  idModuleRequest,
  idModuleTable,
  idPlot,
  idRobotname,
  idText,
  idTypeInfo,
  idTypeInfoRequest,
});
