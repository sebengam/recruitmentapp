package cput.ac.za.recruitmentapp.restApi.humanResource.api.impl;

import android.app.DownloadManager;

import com.android.volley.Response;

import java.io.IOException;

import cput.ac.za.recruitmentapp.conf.util.AppUtil;
import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceExperience;
import cput.ac.za.recruitmentapp.restApi.humanResource.api.HumanResourceExperienceAPI;

/**
 * Created by Tank on 5/8/2016.
 */
public abstract class HumanResourceExperienceAPIImpl implements HumanResourceExperienceAPI
{
    private static final String postUrl = AppUtil.getBaserURI() + "api/humanResource/experience/post";
   private static final String updateUrl = AppUtil.getBaserURI() + "api/humanResource/experience/update";



    @Override
    public HumanResourceExperience createHumanResourceExperience(HumanResourceExperience experience) throws IOException {
        String json = new Gson().toJson(experience);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);
        DownloadManager.Request request = new DownloadManager.Request.Builder()
                .url(postUrl)
                .post(body)
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        PersonAddress personAddress = new Gson().fromJson(value, PersonAddress.class);
        return personAddress;
    }

    @Override
    public PersonAddress updatePersonAddress(PersonAddress address) throws IOException {
        String json = new Gson().toJson(address);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);
        Request request = new Request.Builder()
                .url(updateUrl)
                .post(body)
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        PersonAddress personAddress = new Gson().fromJson(value, PersonAddress.class);
        return personAddress;
    }


}
//