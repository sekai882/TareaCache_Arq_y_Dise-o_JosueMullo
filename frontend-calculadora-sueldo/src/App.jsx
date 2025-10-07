import { useState } from 'react';
import './App.css';

function App() {
    const [baseSueldo, setBaseSueldo] = useState('');
    const [sueldoConBono, setSueldoConBono] = useState(null);
    const [sueldoFinal, setSueldoFinal] = useState(null);

    const calcularSueldoBase = async () => {
        if (!baseSueldo) return;
        try {
            const res = await fetch(`http://localhost:8080/sueldoBase?baseSueldo=${baseSueldo}`);
            const data = await res.json();
            setSueldoConBono(data.resultado);
        } catch {
            alert('❌ Error al calcular sueldo base. ¿El backend está corriendo?');
        }
    };

    const aplicarDescuento = async () => {
        if (!sueldoConBono) return;
        try {
            const res = await fetch(`http://localhost:8080/descuento?sueldo=${sueldoConBono}`);
            const data = await res.json();
            setSueldoFinal(data.resultado);
        } catch {
            alert('❌ Error al aplicar descuento. ¿El backend está corriendo?');
        }
    };

    return (
        <div className="container">
            <h1>Calculadora de Sueldo</h1>

            <input
                type="number"
                placeholder="Ingresa sueldo base"
                value={baseSueldo}
                onChange={(e) => setBaseSueldo(e.target.value)}
            />
            <button onClick={calcularSueldoBase}>Calcular sueldo con bono</button>

            {sueldoConBono !== null && (
                <>
                    <p>💰 Sueldo con bono: {sueldoConBono}</p>
                    <button onClick={aplicarDescuento}>Aplicar descuento</button>
                </>
            )}

            {sueldoFinal !== null && <p>📉 Sueldo final: {sueldoFinal}</p>}
        </div>
    );
}

export default App;
