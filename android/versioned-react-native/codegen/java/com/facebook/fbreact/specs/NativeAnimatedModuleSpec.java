
/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the LICENSE file in the root
 * directory of this source tree.
 *
 * @generated by codegen project: GenerateModuleJavaSpec.js
 *
 * @nolint
 */

package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativeAnimatedModuleSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
  public NativeAnimatedModuleSpec(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @ReactMethod
  public abstract void startOperationBatch();

  @ReactMethod
  public abstract void finishOperationBatch();

  @ReactMethod
  public abstract void createAnimatedNode(double tag, ReadableMap config);

  @ReactMethod
  public abstract void getValue(double tag, Callback saveValueCallback);

  @ReactMethod
  public abstract void startListeningToAnimatedNodeValue(double tag);

  @ReactMethod
  public abstract void stopListeningToAnimatedNodeValue(double tag);

  @ReactMethod
  public abstract void connectAnimatedNodes(double parentTag, double childTag);

  @ReactMethod
  public abstract void disconnectAnimatedNodes(double parentTag, double childTag);

  @ReactMethod
  public abstract void startAnimatingNode(double animationId, double nodeTag, ReadableMap config, Callback endCallback);

  @ReactMethod
  public abstract void stopAnimation(double animationId);

  @ReactMethod
  public abstract void setAnimatedNodeValue(double nodeTag, double value);

  @ReactMethod
  public abstract void setAnimatedNodeOffset(double nodeTag, double offset);

  @ReactMethod
  public abstract void flattenAnimatedNodeOffset(double nodeTag);

  @ReactMethod
  public abstract void extractAnimatedNodeOffset(double nodeTag);

  @ReactMethod
  public abstract void connectAnimatedNodeToView(double nodeTag, double viewTag);

  @ReactMethod
  public abstract void disconnectAnimatedNodeFromView(double nodeTag, double viewTag);

  @ReactMethod
  public abstract void restoreDefaultValues(double nodeTag);

  @ReactMethod
  public abstract void dropAnimatedNode(double tag);

  @ReactMethod
  public abstract void addAnimatedEventToView(double viewTag, String eventName, ReadableMap eventMapping);

  @ReactMethod
  public abstract void removeAnimatedEventFromView(double viewTag, String eventName, double animatedNodeTag);

  @ReactMethod
  public abstract void addListener(String eventName);

  @ReactMethod
  public abstract void removeListeners(double count);
}
