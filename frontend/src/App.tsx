import { useState } from "react";
import './App.css'
import { AssetList } from "../components/asset-list/AssetList.tsx";
import { useAssetData } from "../hooks/useAssetData";

const App = () => {
  const [view, setView] = useState("home");
  const goToUserRegistration = () => setView("register");
  const goToItemList = () => setView("items");
  const { data } = useAssetData();

  return (
    <div style={{ textAlign: "center", padding: "20px" }}>
      <h1>Sistema Gerenciador de Bens</h1>

      {view === "home" && (
        <div className="button-container" style={{ display: "flex", justifyContent: "center", gap: "20px" }}>
          <div>
            <button onClick={goToUserRegistration} style={buttonStyle}>
              Cadastro de Usuários
            </button>

          </div>
          <div>
            <button onClick={goToItemList} style={buttonStyle}>
              Lista de Itens
            </button>
          </div>
        </div>
      )}

      {view === "register" && (
        <div>
          <h2>Cadastro de Usuários</h2>
          <p>Aqui vai o formulário de cadastro.</p>
          <button onClick={() => setView("home")}>Voltar</button>
        </div>
      )}

      {view === "items" && (
        <div>
          <h2>Lista de Itens</h2>
          {data?.map(assetData =>
              <AssetList
                assetCode={assetData.assetCode}
                description={assetData.description}
                type={assetData.type}
                acquisitionDate={assetData.acquisitionDate}
                value={assetData.value}
                status={assetData.status}
              />
            )}
          <button onClick={() => setView("home")}>Voltar</button>
        </div>
      )}
    </div>
  );
};

const buttonStyle = {
  padding: "10px 20px",
  fontSize: "16px",
  cursor: "pointer",
};

export default App;
