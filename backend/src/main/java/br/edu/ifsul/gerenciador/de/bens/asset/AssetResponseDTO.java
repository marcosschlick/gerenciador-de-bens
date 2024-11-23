package br.edu.ifsul.gerenciador.de.bens.asset;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AssetResponseDTO(Long id, int assetCode, String description, AssetType type, LocalDate acquisitionDate,
		BigDecimal value, AssetStatus status, Long departmentId) {

	public AssetResponseDTO(Asset asset) {
		this(asset.getId(), asset.getAssetCode(), asset.getDescription(), asset.getType(), asset.getAcquisitionDate(),
				asset.getValue(), asset.getStatus(), asset.getDepartment().getId());
	}
}
