/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.gmfgraph.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.gmf.gmfgraph.GMFGraphPackage;
import org.eclipse.gmf.gmfgraph.Insets;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Insets</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.InsetsImpl#getTop <em>Top</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.InsetsImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.InsetsImpl#getBottom <em>Bottom</em>}</li>
 *   <li>{@link org.eclipse.gmf.gmfgraph.impl.InsetsImpl#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InsetsImpl extends EObjectImpl implements Insets {
	/**
	 * The default value of the '{@link #getTop() <em>Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTop()
	 * @generated
	 * @ordered
	 */
	protected static final int TOP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTop() <em>Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTop()
	 * @generated
	 * @ordered
	 */
	protected int top = TOP_EDEFAULT;

	/**
	 * The default value of the '{@link #getLeft() <em>Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected static final int LEFT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected int left = LEFT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBottom() <em>Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBottom()
	 * @generated
	 * @ordered
	 */
	protected static final int BOTTOM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBottom() <em>Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBottom()
	 * @generated
	 * @ordered
	 */
	protected int bottom = BOTTOM_EDEFAULT;

	/**
	 * The default value of the '{@link #getRight() <em>Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
	protected static final int RIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
	protected int right = RIGHT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InsetsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GMFGraphPackage.eINSTANCE.getInsets();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTop() {
		return top;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTop(int newTop) {
		int oldTop = top;
		top = newTop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.INSETS__TOP, oldTop, top));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLeft() {
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeft(int newLeft) {
		int oldLeft = left;
		left = newLeft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.INSETS__LEFT, oldLeft, left));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBottom() {
		return bottom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottom(int newBottom) {
		int oldBottom = bottom;
		bottom = newBottom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.INSETS__BOTTOM, oldBottom, bottom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRight() {
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRight(int newRight) {
		int oldRight = right;
		right = newRight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GMFGraphPackage.INSETS__RIGHT, oldRight, right));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GMFGraphPackage.INSETS__TOP:
				return getTop();
			case GMFGraphPackage.INSETS__LEFT:
				return getLeft();
			case GMFGraphPackage.INSETS__BOTTOM:
				return getBottom();
			case GMFGraphPackage.INSETS__RIGHT:
				return getRight();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GMFGraphPackage.INSETS__TOP:
				setTop((Integer)newValue);
				return;
			case GMFGraphPackage.INSETS__LEFT:
				setLeft((Integer)newValue);
				return;
			case GMFGraphPackage.INSETS__BOTTOM:
				setBottom((Integer)newValue);
				return;
			case GMFGraphPackage.INSETS__RIGHT:
				setRight((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GMFGraphPackage.INSETS__TOP:
				setTop(TOP_EDEFAULT);
				return;
			case GMFGraphPackage.INSETS__LEFT:
				setLeft(LEFT_EDEFAULT);
				return;
			case GMFGraphPackage.INSETS__BOTTOM:
				setBottom(BOTTOM_EDEFAULT);
				return;
			case GMFGraphPackage.INSETS__RIGHT:
				setRight(RIGHT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GMFGraphPackage.INSETS__TOP:
				return top != TOP_EDEFAULT;
			case GMFGraphPackage.INSETS__LEFT:
				return left != LEFT_EDEFAULT;
			case GMFGraphPackage.INSETS__BOTTOM:
				return bottom != BOTTOM_EDEFAULT;
			case GMFGraphPackage.INSETS__RIGHT:
				return right != RIGHT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (top: ");
		result.append(top);
		result.append(", left: ");
		result.append(left);
		result.append(", bottom: ");
		result.append(bottom);
		result.append(", right: ");
		result.append(right);
		result.append(')');
		return result.toString();
	}

} //InsetsImpl
