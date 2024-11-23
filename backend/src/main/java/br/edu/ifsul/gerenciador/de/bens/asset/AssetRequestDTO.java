package br.edu.ifsul.gerenciador.de.bens.asset;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AssetRequestDTO(int assetCode, String description, AssetType type, LocalDate acquisitionDate,
		BigDecimal value, AssetStatus status) {

}
