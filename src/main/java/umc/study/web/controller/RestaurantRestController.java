package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.RestaurantConverter;
import umc.study.domain.Restaurant;
import umc.study.service.RestaurantService.RestaurantCommandService;
import umc.study.web.dto.RestaurantRequestDTO;
import umc.study.web.dto.RestaurantResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/{regionId}/region")
    public ApiResponse<RestaurantResponseDTO.addToRegionResultDTO> addToRegion
            (@PathVariable Long regionId,
             @RequestBody @Valid RestaurantRequestDTO.addToRegionDTO request){

        Restaurant restaurant = restaurantCommandService.addToRegion(regionId, request);

        return ApiResponse.onSuccess(RestaurantConverter.toRestaurantDTO(restaurant));
    }
}
