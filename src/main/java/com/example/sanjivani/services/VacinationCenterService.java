package com.example.sanjivani.services;

import com.example.sanjivani.DTO.RequestDTO.AddVacinationCenterRequest;
import com.example.sanjivani.DTO.ResponseDTO.AddVacinationCenterResponse;
import com.example.sanjivani.model.VacinationCenter;
import com.example.sanjivani.repository.VacinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacinationCenterService {
    @Autowired
    VacinationCenterRepository vacinationCenterRepository;

    public AddVacinationCenterResponse addVacinationCenter(AddVacinationCenterRequest addVacinationCenterRequest){
        VacinationCenter vacinationCenter = new VacinationCenter();
        vacinationCenter.setCenterType(addVacinationCenterRequest.getCenterType());
        vacinationCenter.setAddress(addVacinationCenterRequest.getAddress());
        vacinationCenter.setName(addVacinationCenterRequest.getName());

        VacinationCenter savedVacinationCenter = vacinationCenterRepository.save(vacinationCenter);

        AddVacinationCenterResponse vacinationCenterResponse = new AddVacinationCenterResponse();
        vacinationCenterResponse.setName(savedVacinationCenter.getName());
        vacinationCenterResponse.setId(savedVacinationCenter.getId());
        String text = "Vacination center " + savedVacinationCenter.getName() + ", Added Successfully!";
        vacinationCenterResponse.setMessage(text);

        return vacinationCenterResponse;
    }
}
