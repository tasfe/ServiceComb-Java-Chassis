/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.serviceregistry.version;

public abstract class VersionRule {
  private final String versionRule;

  public VersionRule(String versionRule) {
    this.versionRule = versionRule;
  }

  public String getVersionRule() {
    return versionRule;
  }

  // equals isMatch except "latest" rule
  public boolean isAccept(Version version) {
    return isMatch(version, null);
  }

  // latestVersion is only required for "latest" rule
  // it's ugly, but simpler
  public abstract boolean isMatch(Version version, Version latestVersion);
}
