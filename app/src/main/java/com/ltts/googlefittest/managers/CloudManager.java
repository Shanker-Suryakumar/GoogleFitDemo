package com.ltts.googlefittest.managers;

import com.ltts.googlefittest.cloudservice.base.CloudApi;
import com.ltts.googlefittest.cloudservice.base.CloudService;

public class CloudManager {
    private CloudApi mCloudApi;

    public CloudManager() {
        mCloudApi = CloudService.getRetrofitClient().create(CloudApi.class);
    }

   /* public Single<List<PatientModel>> getPatientList() {
        return mCloudApi.getAllPatients()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }*/
}
