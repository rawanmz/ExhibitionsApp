package com.example.exhibitionsapp.domain

import com.example.exhibitionsapp.data.repo.ExhibitionRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetExhibitionsUseCase @Inject constructor(private val exhibitionRepository: ExhibitionRepository) {
    suspend operator fun invoke() = exhibitionRepository.getExhibition()

}