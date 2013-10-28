package N3;

public interface IExpression {

    /// <summary>
    /// находит дифферинциал первого порядка
    /// </summary>
    /// <returns></returns>
	public IExpression diff();

    /// <summary>
    /// возвращает в понятном человеку виде
    /// </summary>
    /// <returns></returns>
	public String show();

    
}