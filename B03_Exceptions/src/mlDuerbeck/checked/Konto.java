package mlDuerbeck.checked;

public class Konto {

	private double saldo;

	public Konto() {
		this(5.0);
	}

	public Konto(double saldo) {
		super();
		this.setSaldo(saldo);
	}

	public double getSaldo() {
		return this.saldo;
	}

	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * Vor dem Abheben einer Summe soll gepr�ft werden ob das Konto ausreichend
	 * gedeckt ist, wenn nicht, soll eine "NegativeSaldoException" mit dem
	 * Aktuellen Saldo und dem abzuhebenden Betrag als Nachricht geworfen werden.
	 * 
	 * Es geht hier um eine "Checked" Exception
 	 */
	public void geldAbheben(double saldo) throws NegativeSaldoException  {
		
		if (this.getSaldo() < saldo) {
			double tempSaldo = this.getSaldo();
			this.setSaldo(0);
			throw new NegativeSaldoException("Der aktuelle Saldo ist niedriger als der Abhebe-Betrag. Daher werden Ihnen " + tempSaldo + "Euro ausgezahlt.");
		} else {
			this.setSaldo((getSaldo() - saldo));
			System.out.println("Es werden " + saldo + "Euro abgehoben.");
		}
		
		

	}

	public void geldEinzahlen(double saldo) {
		this.setSaldo(this.getSaldo() + saldo);
	}

	@Override
	public String toString() {
		return "Saldo verfuegbar = " + this.getSaldo();
	}
}

class NegativeSaldoException extends Exception {
	public NegativeSaldoException() {
		
	}
	
	public NegativeSaldoException(String message) {
		super(message);
	}
}
