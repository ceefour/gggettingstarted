package com.hendyirawan.gggettingstarted.simple;

public class YagoRule {
	String property;
	String questionPattern_en;
	String questionPattern_id;
	String answerTemplateHtml_en;
	String answerTemplateHtml_id;
	
	public YagoRule(String property, String questionPattern_en,
			String questionPattern_id, String answerTemplateHtml_en,
			String answerTemplateHtml_id) {
		super();
		this.property = property;
		this.questionPattern_en = questionPattern_en;
		this.questionPattern_id = questionPattern_id;
		this.answerTemplateHtml_en = answerTemplateHtml_en;
		this.answerTemplateHtml_id = answerTemplateHtml_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "YagoRule [property=" + property + ", questionPattern_en="
				+ questionPattern_en + ", questionPattern_id="
				+ questionPattern_id + ", answerTemplateHtml_en="
				+ answerTemplateHtml_en + ", answerTemplateHtml_id="
				+ answerTemplateHtml_id + "]";
	}
	
}