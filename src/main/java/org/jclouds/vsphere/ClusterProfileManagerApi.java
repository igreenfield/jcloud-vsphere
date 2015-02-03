/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jclouds.vsphere;

import com.vmware.vim25.DuplicateName;
import com.vmware.vim25.ProfileCreateSpec;
import com.vmware.vim25.ProfilePolicyMetadata;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.Profile;

import java.rmi.RemoteException;
import java.util.List;

/**
 */
public interface ClusterProfileManagerApi {
   List<Profile> getProfile();

   List<Profile> createProfile(ProfileCreateSpec createSpec) throws DuplicateName, RuntimeFault, RemoteException;

   List<Profile> findAssociatedProfile(ManagedEntity entity) throws RuntimeFault, RemoteException;

   /**
    * SDK4.1 signature for back compatibility
    */
   List<ProfilePolicyMetadata> queryPolicyMetadata(List<String> policyName) throws RuntimeFault, RemoteException;

   /**
    * SDK5.0 signature
    */
   List<ProfilePolicyMetadata> queryPolicyMetadata(List<String> policyName, Profile profile) throws RuntimeFault, RemoteException;
}
