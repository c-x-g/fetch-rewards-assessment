package com.example.fetchrewardsassessment.controller;

import com.example.fetchrewardsassessment.model.Versions;
import com.example.fetchrewardsassessment.service.CompareVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CompareVersionController {

    @Autowired
    CompareVersionService compareVersionService;

    @ResponseBody
    @RequestMapping("/versions")
    public String compareVersions(@RequestBody Versions versions) {
        String result = compareVersionService.compareVersion(versions.getVersion1(), versions.getVersion2());
        return result.equals("equal") ?
                versions.getVersion1() + " is "+ result + " to " + versions.getVersion2() +"\n"
             : result.equals("before") || result.equals("after") ?
                versions.getVersion1() + " is "+ result + " " + versions.getVersion2() +"\n"
             : result;
    }
}
