package cput.ac.za.recruitmentapp.restApi.humanResource.api.impl;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

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
        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();
        com.squareup.okhttp.Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        HumanResourceExperience humanResourceExperience = new Gson().fromJson(value, HumanResourceExperience.class);
        return humanResourceExperience;
    }

    @Override
    public HumanResourceExperience updateHumanResourceExperience(HumanResourceExperience experience) throws IOException {
        String json = new Gson().toJson(experience);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);
        Request request = new Request.Builder()
                .url(updateUrl)
                .post(body)
                .build();
        com.squareup.okhttp.Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        HumanResourceExperience humanResourceExperience = new Gson().fromJson(value, HumanResourceExperience.class);
        return humanResourceExperience;
    }


    public abstract HumanResourceExperience updateHumanResourceExperince(HumanResourceExperience experience) throws IOException;
}
